/**
 * Stellt einen Fülstotzen dar.
 */
public class Fuellstotzen {
	
	private float mMaxFuellung;
	private boolean mIstAbgenommen;
	private int mNummer;
	private Treibstoff mTreibstoff;
	private Zapfsaeule mZapfsaeule;
	
	/**
	 * Gibt den Treibstoff zurück
	 * @return
	 *  Der Treibstoff
	 */
	public Treibstoff getTreibstoff() {
		return mTreibstoff;
	}
	/**
	 * Setzt den Treibstoff
	 * @param pTreibstoff
	 *  Der wert des Treibstoffes.
	 */
	public void setTreibstoff(Treibstoff pTreibstoff) {
		mTreibstoff = pTreibstoff;
	}
	/**
	 * Gibt die Zapfsäulen zurück
	 * @return
	 *  Die Zapfsäulen
	 */
	public Zapfsaeule getZapfsaeule() {
		return mZapfsaeule;
	}
	/**
	 * Setzt die Zapfsäule an dem Der Stotzen häng.
	 * @param mpZapfsaeule
	 *   Der Wert der Zapfsäule 
	 */
	public void setZapfsaeule(Zapfsaeule pZapfsaeule) {
		mZapfsaeule = pZapfsaeule;
	}
	/**
	 * Gibt die Maximale Füllung zurück.
	 * @return
	 *  Die maximale Füllung.
	 */
	public float getMaxFuellung() {
		return mMaxFuellung;
	}
	/**
	 * Setzt die Maximale fülmenge
	 * @param pMaxFuellung
	 *  Der Wert der maximlen Fülmenge.
	 */
	public void setMaxFuellung(float pMaxFuellung) {
		mMaxFuellung = pMaxFuellung;
	}
	/**
	 * Sagt ob der Fülstotzen abgenommen worden ist.
	 * @return
	 *  Ob er abgenommen ist.
	 */
	public boolean isIstAbgenommen() {
		return mIstAbgenommen;
	}
	/**
	 * Setzt ob der Fülstotzen abgenommen worden ist.
	 * @param pIstAbgenommen
	 *  Der Wert ob er agbenommen worden ist.
	 */
	public void setIstAbgenommen(boolean pIstAbgenommen) {
		mIstAbgenommen = pIstAbgenommen;
	}
	/**
	 * Gibt die Nummer der Zapfsäule zurück.
	 * @return
	 *  Die Nummer.
	 */
	public int getNummer() {
		return mNummer;
	}
	/**
	 * Setzt den Wert der Nummer.
	 * @param pNummer
	 *  Der Wert der Nummer.
	 */
	public void setNummer(int pNummer) {
		mNummer = pNummer;
	}
}
