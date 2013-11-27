import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse der Zapfsaeule
 */
public class Zapfsaeule {
	// Memberdeklaration
	private int mNummer;
	private float mGetankteLiter;
	private boolean mIstTankbar;
	private Kasse mKasse;
	private List<Fuellstotzen> mFuellstotzenliste = new ArrayList<Fuellstotzen>();;
	
	/**
	 * Gibt die Kasse zurück
	 * @return
	 * 	Die Kasse
	 */
	public Kasse getKasse() {
		return mKasse;
	}

	/**
	 * Setzt die Kasse
	 * @param pKasse
	 * 	Der Wert Kasse
	 */
	public void setKasse(Kasse pKasse) {
		mKasse = pKasse;
	}

	/**
	 * Gibt die Nummer zurück
	 * @return
	 *  Die Nummer
	 */
	public int getNummer() {
		return mNummer;
	}

	/**
	 * Setzt die Nummer
	 * @param pNummer
	 *  Der Wert der Nummer
	 */
	public void setNummer(int pNummer) {
		mNummer = pNummer;
	}

	/**
	 * Gibt die anzahl Getankte Liter zurück.
	 * @return
	 * 	Die anzahl getankten Liter
	 */
	public float getGetankteLiter() {
		return mGetankteLiter;
	}

	/**
	 * Setzt die Anzahl getankte Liter
	 * @param pGetankteLiter
	 * 	Die Wert der Anzahl getankten Liter
	 */
	public void setGetankteLiter(float pGetankteLiter) {
		mGetankteLiter = pGetankteLiter;
	}

	/**
	 * Gibt zurück ob die Zapfsäule Tankbar ist
	 * @return
	 * 	Ob die Tanksäule tankbar ist.
	 */
	public boolean isIstTankbar() {
		return mIstTankbar;
	}

	/**
	 * Setzt ob die Zapfsäule Tankbar ist.
	 * @param pIstTankbar
	 *  Der Wert ob die Säule tankbar ist.
	 */
	public void setIstTankbar(boolean pIstTankbar) {
		mIstTankbar = pIstTankbar;
	}

	/**
	 * Gibt die Fülstotzen der Zapfsäule zurück.
	 * @return
	 *  Die Fülstotzten
	 */
	public List<Fuellstotzen> getFuellstotzenliste() {
		return mFuellstotzenliste;
	}

	/**
	 * Setzt die Fülstotzen der Zapfsäule
	 * @param pFuellstotzenliste
	 */
	public void setFuellstotzenliste(List<Fuellstotzen> pFuellstotzenliste) {
		mFuellstotzenliste = pFuellstotzenliste;
	}

	
	/**
	 * Default Konstruktor
	 *  Initialisiert eine Neue instanz der klasse Zapfsaeule
	 */
	public Zapfsaeule(){
		
	}
	
	/**
	 * Tankt eine bestimmte Anzahl Liter und enzieht so den Treibstoftanks
	 * Inhalt.
	 * @param pAnzahlLiter
	 *  Die zu tankende Anzahl Liter.
	 */
	public void tanken(float pAnzahlLiter){
		
		boolean lTankbar = false;
		Fuellstotzen lAbgenommenerFuelstotzen = null;
		for (Fuellstotzen lFuelstotzen : mFuellstotzenliste) {
			
			if (lFuelstotzen.isIstAbgenommen()) {
				
				lTankbar = true;
				lAbgenommenerFuelstotzen = lFuelstotzen;
			}
		}
		
		if (lTankbar) {
			
			if (lAbgenommenerFuelstotzen != null) {
				
				float lTotaleTreibstoffmenge = 0f;
				for (Treibstofftank lTreibstofftank : lAbgenommenerFuelstotzen.getTreibstoff().getTreibstofftanks()) {
					
					lTotaleTreibstoffmenge += lTreibstofftank.getFuelstand();
				}
				
				if (lTotaleTreibstoffmenge >= pAnzahlLiter) {
					
					if (lAbgenommenerFuelstotzen.getMaxFuellung() > (mGetankteLiter + pAnzahlLiter)) {
						
						// Alle überprüfungen abgeschlossen, nun kann getankt werden.
						mGetankteLiter += pAnzahlLiter;
						
						for (Treibstofftank lTreibstofftank : lAbgenommenerFuelstotzen.getTreibstoff().getTreibstofftanks()) {
							
							float lProzentVonTotaleMenge = lTreibstofftank.getFuelstand() / lTotaleTreibstoffmenge;
							float lTankInhalt = lTreibstofftank.getFuelstand();
							lTankInhalt -= (pAnzahlLiter * lProzentVonTotaleMenge);
							lTreibstofftank.setFuelstand(lTankInhalt);
						}
						
						System.out.println("Getankt: " + lAbgenommenerFuelstotzen.getTreibstoff().getBezeichnung() + " Anz. Liter: " + 
						pAnzahlLiter + " Tot. Getankt: " + mGetankteLiter + " Preis: " +
								mGetankteLiter * lAbgenommenerFuelstotzen.getTreibstoff().getPreisProLiter() + " CHF");
						
					} else {
						
						System.out.println("Die gewünschte Anzahl Liter können nicht getankt werden. Maximum überschritten.");
					}
				} else {
					
					System.out.println("In den Tanks ist zu wenig des gewünschten Treibstoffes vorhanden.");
				}
				
			} else {
				
				System.out.println("Kein Fülstotzen abgenommen.");
			}
		} else {
			
			System.out.println("Bitte zuerst fuelstotzen abnehmen.");
		}
	}
	
	/**
	 * Nimmt einen Fülstotzen mit einer Bestimmten Nummer an der Zapfsäule ab.
	 * @param pNr
	 *  Die Nummer der Zapfsäule.
	 */
	public void fuellstotzenAbnehmen(int pNr){
		
		if (mIstTankbar) {
			
			for (Fuellstotzen lFuelstotzen : mFuellstotzenliste) {
				
				if (lFuelstotzen.getNummer() == pNr) {
					
					mIstTankbar = false;
					lFuelstotzen.setIstAbgenommen(true);
				}
			}
		} else {
			
			System.out.println("Zurzeit kann nicht getankt werden.");
		}
	}
	
	/**
	 * Legt (wenn ein Fülstotzen abgenommen wurde) diesen wieder auf.
	 */
	public void fuellstotzenAuflegen(){
		
		boolean lWurdeAufgelegt = false;
		Fuellstotzen lAufgelegterFuelstotzen = null;
		
		for (Fuellstotzen lFuelstotzen : mFuellstotzenliste) {
			
			if (lFuelstotzen.isIstAbgenommen()) {
				
				lFuelstotzen.setIstAbgenommen(false);
				lAufgelegterFuelstotzen = lFuelstotzen;
				lWurdeAufgelegt = true;
			}
		}
		
		
		if (lWurdeAufgelegt) {
			
			// Wenn nicht getankt wurde, 
			if (mGetankteLiter <= 0 && !mIstTankbar) {
				
				mIstTankbar = true;
			} else {
				
				mKasse.neueTankung(mNummer, mGetankteLiter, lAufgelegterFuelstotzen.getTreibstoff().getBezeichnung());
				
				// getankte Liter zurücksetzten.
				mGetankteLiter = 0f;
			}
		} else {
			
			System.out.println("Es wurde kein Fuelstotzen aufgelegt.");
		}
	}
}
