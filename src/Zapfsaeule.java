import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Lukas
 * Die Klasse der Zapfsaeule
 *
 */
 

public class Zapfsaeule {
	// Memberdeklaration
	private int mNummer;
	private float mGetankteLiter;
	private boolean mIstTankbar;
	private List<Fuellstotzen> mFuellstotzenliste = new ArrayList<Fuellstotzen>();;
	
	
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
		
	}
	
	public void fuellstotzenAbnehmen(int pNr){
		
	}
	
	public void fuellstotzenAuflegen(){
		
	}
	
}
