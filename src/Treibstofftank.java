/**
 * Stellt einen Treibstofftank dar.
 */
public class Treibstofftank {
	
	private float mFuelstand;
	private float mMaxFuelmenge;
	
	
	public float getFuelstand() {
		return mFuelstand;
	}
	public void setFuelstand(float pFuelstand) {
		if (pFuelstand > mMaxFuelmenge) {
			
			mFuelstand = mMaxFuelmenge;
		} else {
			
			mFuelstand = pFuelstand;
		}
		
	}
	public float getMaxFuelmenge() {
		return mMaxFuelmenge;
	}
	public void setMaxFuelmenge(float pMaxFuelmenge) {
		mMaxFuelmenge = pMaxFuelmenge;
	}
}
