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
	
	private Tankstelle mTankstelle;
	private List<Integer> mLockedZapfsaeulenId = new ArrayList<Integer>();

	public Tankstelle getTankstelle() {
		return mTankstelle;
	}

	public void setTankstelle(Tankstelle pTankstelle) {
		this.mTankstelle = pTankstelle;
	}
	
	public void addLockedZapfsaeulenId(int pId) {
		mLockedZapfsaeulenId.add(pId);
	}
	
	public void removeLockedZapfsaeulenId(int pId) {
		for (Integer lId : mLockedZapfsaeulenId) {
			if (pId == lId) {
				mLockedZapfsaeulenId.remove(lId);
				// für geschwindigkeitsoptimierung
				break;
			}
		}
	}
	
	/**
	 * Eine noch nicht bezahlte Tankung zahlen und die Zapfsäule wieder Freigeben.
	 * @param pZapfsaeuleNummer
	 *  Die zapfsäule an der getankt wurde.
	 */
	public void tankungBezahlen(int pZapfsaeuleNummer) {
		// aktelle nicht beglichene tankung finden
		Tankung lTankung = tankungenDurchsuchen(pZapfsaeuleNummer, false); 
		
		if (lTankung != null){
			
			// Tankung auf bezahlt setzen
			lTankung.setIstTankungAbgerechhnet(true);
			
			// Zapfsäule freigeben
			for (Zapfsaeule lZapfseule : mTankstelle.getZapfsaeulen()){
				if (lZapfseule.getNummer() == pZapfsaeuleNummer){
					lZapfseule.setIstTankbar(true);	
					removeLockedZapfsaeulenId(lZapfseule.getNummer());
					// geschwindigkeit erhöhen
					break;
				}
			}
		}
		else{
			System.out.println("Keine nichtbeglichene Rechnung der Zapfsäule " + pZapfsaeuleNummer + " gefunden!");
		}
		
	}
	
	/**
	 * Wertet den Umsatz in einem gewissen Zeitraum aus.
	 * Stunde, Minute, Sekunde wird automatisch so ergänzt, damit
	 * automatisch das Grösste Intervall von Datum zu Datum verwendet wird
	 * @param pVon
	 *  Anfang der Auswertung
	 * @param pBis
	 *  Ende der Auswertung.
	 */
	@SuppressWarnings("static-access")
	public void auswerten(Calendar pVon, Calendar pBis) {
		float lUmsatz = 0f; // Umsatz im Zeitraum
		DateFormat lFormatierer = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY); // Formatierer für Date-Objekte
		
		// Anpassung der Datumswerten, damit sie den ganzen Zeitraum umfassen.
		pVon.set(pVon.HOUR_OF_DAY, 0);
		pVon.set(pVon.MINUTE, 0);
		pVon.set(pVon.SECOND, 0);
		
		pBis.set(pBis.HOUR_OF_DAY, 23);
		pBis.set(pBis.MINUTE, 59);
		pBis.set(pBis.SECOND, 59);
		
		
		// Tankungen auf im Zeitraum zu Liste hinzufügen
		for (Tankung lTankung : mTankstelle.getTankungen()){
			// auf Zeitraum überprüfen
			
			if(lTankung.getTankDatum().compareTo(pVon) >= 0 && lTankung.getTankDatum().compareTo(pBis) <= 0){
				lUmsatz += lTankung.getAnzahlGetankteLiter() * lTankung.getPreisProLiterzuTankdatum();
			}
		}
		System.out.format("\n\nDer Gesamtumsatz für den Zeitraum vom %s, bis am %s ist %.2f", lFormatierer.format(pVon.getTime()), lFormatierer.format(pBis.getTime()), Math.round(lUmsatz * 20f) / 20f);
	}
	
	/**
	 * Erstellt eine Neue noch nicht abgerechnete Tankung.
	 * @param pZapfnr
	 *  Die Zapfsäulennummer
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
		
		for (Treibstoff lTreibstoff : mTankstelle.getTeibstoffe()) {
			
			if (lTreibstoff.getBezeichnung() == pTreibstoff) {
				
				lTankung.setPreisProLiterzuTankdatum(lTreibstoff.getPreisProLiter());
			}
		}
		mTankstelle.addTankung(lTankung);
	}
	
	// private Methoden
	/**
	 * Ergibt referenz auf Tankung von Zapfsäule, welche dem istTankbar-Wert entspricht. Wenn keine null
	 * Achtung: Sie arbeiten nun auf der mTankungen-liste
	 * 
	 * @param pZapfseuleNummer
	 * @param istTankbar
	 * @return Tankung 
	 */
	private Tankung	tankungenDurchsuchen(int pZapfseuleNummer, boolean istBeglichen){
		Tankung lTankung = null;
		
		// nach nicht beglichener Tankung suchen für angegebene Zapfseule
		for (Tankung lTankungstepper : mTankstelle.getTankungen()){
			if (lTankungstepper.getZapfNummer() == pZapfseuleNummer && lTankungstepper.isIstTankungAbgerechhnet() == istBeglichen){
				lTankung = lTankungstepper;
				
				//damit nicht unnötig mehr durchgesteppt wird (es kann nur 1 tankung gefunden werden)
				break; 
			}
		}
		
		return (lTankung);
	}
	
}
