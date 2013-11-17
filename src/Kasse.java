import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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
	 * Wertet den Umsatz in einer Gewissen Zeit aus.
	 * @param pVon
	 *  Anfang der Auswertung
	 * @param pBis
	 *  Ende der Auswertung.
	 */
	public void auswerten(Date pVon, Date pBis) {
		
	}
	
	/**
	 * Gibt die Preise aller Treibstoffe auf dem Bilschirm aus.
	 */
	public void printPreisTafel() {
		
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
		lTankung.setTankDatum(new Date());
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
