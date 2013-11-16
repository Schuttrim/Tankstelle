/**
 * Stellt einen Fülstotzen dar.
 */
public class Fuellstotzen {
	
	private float mMaxFuellung;
	private boolean mIstAbgenommen;
	private int mNummer;
	private Treibstoff mTreibstoff;
	private Zapfsaeule mZapfsaeule;
	
	public Treibstoff getTreibstoff() {
		return mTreibstoff;
	}
	public void setTreibstoff(Treibstoff pTreibstoff) {
		mTreibstoff = pTreibstoff;
	}
	public Zapfsaeule getZapfsaeule() {
		return mZapfsaeule;
	}
	public void setZapfsaeule(Zapfsaeule mpZapfsaeule) {
		mZapfsaeule = mpZapfsaeule;
	}
	public float getMaxFuellung() {
		return mMaxFuellung;
	}
	public void setMaxFuellung(float pMaxFuellung) {
		mMaxFuellung = pMaxFuellung;
	}
	public boolean isIstAbgenommen() {
		return mIstAbgenommen;
	}
	public void setIstAbgenommen(boolean pIstAbgenommen) {
		mIstAbgenommen = pIstAbgenommen;
	}
	public int getNummer() {
		return mNummer;
	}
	public void setNummer(int pNummer) {
		mNummer = pNummer;
	}
}
