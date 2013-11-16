/**
 * Stellt einen F�lstotzen dar.
 */
public class Fuellstotzen {
	
	private float mMaxFuellung;
	private boolean mIstAbgenommen;
	private int mNummer;
	private Treibstoff mTreibstoff;
	private Zapfsaeule mZapfsaeule;
	
	/**
	 * Gibt den Treibstoff zur�ck
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
	 * Gibt die Zapfs�ulen zur�ck
	 * @return
	 *  Die Zapfs�ulen
	 */
	public Zapfsaeule getZapfsaeule() {
		return mZapfsaeule;
	}
	/**
	 * Setzt die Zapfs�ule an dem Der Stotzen h�ng.
	 * @param mpZapfsaeule
	 *   Der Wert der Zapfs�ule 
	 */
	public void setZapfsaeule(Zapfsaeule pZapfsaeule) {
		mZapfsaeule = pZapfsaeule;
	}
	/**
	 * Gibt die Maximale F�llung zur�ck.
	 * @return
	 *  Die maximale F�llung.
	 */
	public float getMaxFuellung() {
		return mMaxFuellung;
	}
	/**
	 * Setzt die Maximale f�lmenge
	 * @param pMaxFuellung
	 *  Der Wert der maximlen F�lmenge.
	 */
	public void setMaxFuellung(float pMaxFuellung) {
		mMaxFuellung = pMaxFuellung;
	}
	/**
	 * Sagt ob der F�lstotzen abgenommen worden ist.
	 * @return
	 *  Ob er abgenommen ist.
	 */
	public boolean isIstAbgenommen() {
		return mIstAbgenommen;
	}
	/**
	 * Setzt ob der F�lstotzen abgenommen worden ist.
	 * @param pIstAbgenommen
	 *  Der Wert ob er agbenommen worden ist.
	 */
	public void setIstAbgenommen(boolean pIstAbgenommen) {
		mIstAbgenommen = pIstAbgenommen;
	}
	/**
	 * Gibt die Nummer der Zapfs�ule zur�ck.
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
