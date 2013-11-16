/**
 * Stellt einen Treibstofftank dar.
 */
public class Treibstofftank {
	
	private int mFuelstand;
	private int mMaxFuelmenge;
	
	
	public int getFuelstand() {
		return mFuelstand;
	}
	public void setFuelstand(int pFuelstand) {
		if (pFuelstand > mMaxFuelmenge) {
			
			mFuelstand = mMaxFuelmenge;
		} else {
			
			mFuelstand = pFuelstand;
		}
		
	}
	public int getMaxFuelmenge() {
		return mMaxFuelmenge;
	}
	public void setMaxFuelmenge(int pMaxFuelmenge) {
		mMaxFuelmenge = pMaxFuelmenge;
	}
}
