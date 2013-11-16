/**
 * Stellt einen Treibstofftank dar.
 */
public class Treibstofftank {
	
	private float mFuelstand;
	private float mMaxFuelmenge;
	
	/**
	 * Gibt den Füllstand zurück.
	 * @return
	 *  Der Wert des Fülstandes
	 */
	public float getFuelstand() {
		return mFuelstand;
	}
	/**
	 * Setzt den Füllstand wenn dieser nicht höher ist als 
	 * der maximale Fülstand. Dann Füllstand = MaxFüllstand.
	 * @param pFuelstand
	 *  Der Wert des Fülstandes.
	 */
	public void setFuelstand(float pFuelstand) {
		if (pFuelstand > mMaxFuelmenge) {
			
			mFuelstand = mMaxFuelmenge;
		} else {
			
			mFuelstand = pFuelstand;
		}
		
	}
	/**
	 * Gibt die Maximale Füllmenge zurück.
	 * @return
	 *  Die Maximale füllmenge.
	 */
	public float getMaxFuelmenge() {
		return mMaxFuelmenge;
	}
	/**
	 * Setzt die maximale Füllmenge
	 * @param pMaxFuelmenge
	 *  Der Wert der maximalen Füllmenge.
	 */
	public void setMaxFuelmenge(float pMaxFuelmenge) {
		mMaxFuelmenge = pMaxFuelmenge;
	}
}
