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
	
	
	public Kasse getKasse() {
		return mKasse;
	}

	public void setKasse(Kasse pKasse) {
		mKasse = pKasse;
	}

	public int getNummer() {
		return mNummer;
	}

	public void setNummer(int pNummer) {
		mNummer = pNummer;
	}

	public float getGetankteLiter() {
		return mGetankteLiter;
	}

	public void setGetankteLiter(float pGetankteLiter) {
		mGetankteLiter = pGetankteLiter;
	}

	public boolean isIstTankbar() {
		return mIstTankbar;
	}

	public void setIstTankbar(boolean pIstTankbar) {
		mIstTankbar = pIstTankbar;
	}

	public List<Fuellstotzen> getFuellstotzenliste() {
		return mFuellstotzenliste;
	}

	public void setFuellstotzenliste(List<Fuellstotzen> pFuellstotzenliste) {
		mFuellstotzenliste = pFuellstotzenliste;
	}

	
	
	public Zapfsaeule(){
		
	}
	
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
			}
		} else {
			
			System.out.println("Es wurde kein Fuelstotzen aufgelegt.");
		}
	}
}
