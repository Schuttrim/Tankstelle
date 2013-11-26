import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * Stellt eine Kasse dar.
 */
public class Kasse {
	
	private List<Treibstoff> mTeibstoffe = new ArrayList<Treibstoff>();
	private List<Tankung> mTankungen = new ArrayList<Tankung>();
	private List<Zapfsaeule> mZapfsaeulen = new ArrayList<Zapfsaeule>();
	
	
	
	// public Methoden
	/**
	 * Gibt die Treibstoffe zur�ck
	 * @return
	 *  Die Treibstoffe.
	 */
	public List<Treibstoff> getTeibstoffe() {
		return mTeibstoffe;
	}

	/**
	 * Setzt die Treibstoffe
	 * @param pTeibstoffe
	 *  Der Wert der Treibstoffe.
	 */
	public void setTeibstoffe(List<Treibstoff> pTeibstoffe) {
		mTeibstoffe = pTeibstoffe;
	}
	
	/**
	 * Gibt die Tankungen zur�ck
	 * @return
	 *  Die Tankunge.
	 */
	public List<Tankung> getTankungen() {
		return mTankungen;
	}

	/**
	 * Setzt die Tankungen
	 * @param pTankungen
	 *  Der Wert der Tankungen
	 */
	public void setTankungen(List<Tankung> pTankungen) {
		mTankungen = pTankungen;
	}

	/**
	 * Gibt die Zapfs�ulen zur�ck.
	 * @return
	 *  Die Zapfs�ulen.
	 */
	public List<Zapfsaeule> getZapfsaeulen() {
		return mZapfsaeulen;
	}

	/**
	 * Setzt den Wert der Zapfs�ulen
	 * @param pZapfsaeulen
	 *  Den Wert der Zapfs�ulen.
	 */
	public void setZapfsaeulen(List<Zapfsaeule> pZapfsaeulen) {
		mZapfsaeulen = pZapfsaeulen;
	}
	
	/**
	 * Eine noch nicht bezahlte Tankung zahlen und die Zapfs�ule wieder Freigeben.
	 * @param pZapfsaeuleNummer
	 *  Die zapfs�ule an der getankt wurde.
	 */
	public void tankungBezahlen(int pZapfsaeuleNummer) {
		// aktelle nicht beglichene tankung finden
		Tankung lTankung = tankungenDurchsuchen(pZapfsaeuleNummer, false); 
		
		if (lTankung != null){
			
			// Tankung auf bezahlt setzen
			lTankung.setIstTankungAbgerechhnet(true);
			
			// Zapfs�ule freigeben
			for (Zapfsaeule lZapfseule : mZapfsaeulen){
				if (lZapfseule.getNummer() == pZapfsaeuleNummer){
					lZapfseule.setIstTankbar(true);	
					
					// geschwindigkeit erh�hen
					break;
				}
			}
		}
		else{
			System.out.println("Keine nichtbeglichene Rechnung der Zapfs�ule " + pZapfsaeuleNummer + " gefunden!");
		}
		
	}
	
	/**
	 * Wertet den Umsatz in einem gewissen Zeitraum aus.
	 * Stunde, Minute, Sekunde wird automatisch so erg�nzt, damit
	 * automatisch das Gr�sste Intervall von Datum zu Datum verwendet wird
	 * @param pVon
	 *  Anfang der Auswertung
	 * @param pBis
	 *  Ende der Auswertung.
	 */
	@SuppressWarnings("static-access")
	public void auswerten(Calendar pVon, Calendar pBis) {
		float lUmsatz = 0f; // Umsatz im Zeitraum
		DateFormat lFormatierer = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY); // Formatierer f�r Date-Objekte
		
		// Anpassung der Datumswerten, damit sie den ganzen Zeitraum umfassen.
		pVon.set(pVon.HOUR_OF_DAY, 0);
		pVon.set(pVon.MINUTE, 0);
		pVon.set(pVon.SECOND, 0);
		
		pBis.set(pBis.HOUR_OF_DAY, 23);
		pBis.set(pBis.MINUTE, 59);
		pBis.set(pBis.SECOND, 59);
		
		
		// Tankungen auf im Zeitraum zu Liste hinzuf�gen
		for (Tankung lTankung : mTankungen){
			// auf Zeitraum �berpr�fen
			
			if(lTankung.getTankDatum().compareTo(pVon) >= 0 && lTankung.getTankDatum().compareTo(pBis) <= 0){
				lUmsatz += lTankung.getAnzahlGetankteLiter() * lTankung.getPreisProLiterzuTankdatum();
			}
		}
		System.out.format("\n\nDer Gesamtumsatz f�r den Zeitraum vom %s, bis am %s ist %.2f", lFormatierer.format(pVon.getTime()), lFormatierer.format(pBis.getTime()), lUmsatz);
	}
	
	/**
	 * Gibt die Preise aller Treibstoffe auf dem Bilschirm aus.
	 */
	public void printPreisTafel() {
		System.out.println("\nDie aktuellen Preise sind:");
		
		for (Treibstoff lTreibstoff : mTeibstoffe){
			System.out.format(" - %s: %4.2f Fr.\n", lTreibstoff.getBezeichnung(), lTreibstoff.getPreisProLiter());
		}
		
		System.out.println();
	}
	
	/**
	 * Erstellt eine Neue noch nicht abgerechnete Tankung.
	 * @param pZapfnr
	 *  Die Zapfs�ulennummer
	 * @param pLiter
	 * 	Die Anzahl Liter die getankt wurden.
	 * @param pTreibstoff
	 *  Der Treibstoffname als String
	 */
	public void neueTankung(int pZapfnr, float pLiter, String pTreibstoff) {
		
		Tankung lTankung = new Tankung();
		lTankung.setAnzahlGetankteLiter(pLiter);
		lTankung.setGetankterTreibstoffBezeichnung(pTreibstoff);
		lTankung.setIstTankungAbgerechhnet(false);
		lTankung.setTankDatum(Calendar.getInstance());
		lTankung.setZapfNummer(pZapfnr);
		
		for (Treibstoff lTreibstoff : mTeibstoffe) {
			
			if (lTreibstoff.getBezeichnung() == pTreibstoff) {
				
				lTankung.setPreisProLiterzuTankdatum(lTreibstoff.getPreisProLiter());
			}
		}
		mTankungen.add(lTankung);
	}
	
	// private Methoden
	/**
	 * Ergibt referenz auf Tankung von Zapfs�ule, welche dem istTankbar-Wert entspricht. Wenn keine null
	 * Achtung: Sie arbeiten nun auf der mTankungen-liste
	 * 
	 * @param pZapfseuleNummer
	 * @param istTankbar
	 * @return Tankung 
	 */
	private Tankung	tankungenDurchsuchen(int pZapfseuleNummer, boolean istBeglichen){
		Tankung lTankung = null;
		
		// nach nicht beglichener Tankung suchen f�r angegebene Zapfseule
		for (Tankung lTankungstepper : mTankungen){
			if (lTankungstepper.getZapfNummer() == pZapfseuleNummer && lTankungstepper.isIstTankungAbgerechhnet() == istBeglichen){
				lTankung = lTankungstepper;
				
				//damit nicht unn�tig mehr durchgesteppt wird (es kann nur 1 tankung gefunden werden)
				break; 
			}
		}
		
		return (lTankung);
	}
	
}
