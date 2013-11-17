/**
 * Stellt einen Treibstofftank dar.
 */
public class Treibstofftank {
	
	private float mFuelstand;
	private float mMaxFuelmenge;
	
	/**
	 * Gibt den F�llstand zur�ck.
	 * @return
	 *  Der Wert des F�lstandes
	 */
	public float getFuelstand() {
		return mFuelstand;
	}
	/**
	 * Setzt den F�llstand wenn dieser nicht h�her ist als 
	 * der maximale F�lstand. Dann F�llstand = MaxF�llstand.
	 * @param pFuelstand
	 *  Der Wert des F�lstandes.
	 */
	public void setFuelstand(float pFuelstand) {
		if (pFuelstand > mMaxFuelmenge) {
			
			mFuelstand = mMaxFuelmenge;
		} else {
			
			mFuelstand = pFuelstand;
		}
		
	}
	/**
	 * Gibt die Maximale F�llmenge zur�ck.
	 * @return
	 *  Die Maximale f�llmenge.
	 */
	public float getMaxFuelmenge() {
		return mMaxFuelmenge;
	}
	/**
	 * Setzt die maximale F�llmenge
	 * @param pMaxFuelmenge
	 *  Der Wert der maximalen F�llmenge.
	 */
	public void setMaxFuelmenge(float pMaxFuelmenge) {
		mMaxFuelmenge = pMaxFuelmenge;
	}
}
