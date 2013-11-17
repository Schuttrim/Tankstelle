import java.util.Date;

/**
 * Stellt eine Tankung dar.
 */
public class Tankung {
	
	private float mAnzahlGetankteLiter;
	private boolean mIstTankungAbgerechhnet;
	private String mGetankterTreibstoffBezeichnung;
	private Date mTankDatum;
	private float mPreisProLiterzuTankdatum;
	private int mZapfNummer;
	
	
	/**
	 * Gibt die Anzahl getankter Liter zurück.
	 * @return
	 *  Die Anzahl getankter Liter
	 */
	public float getAnzahlGetankteLiter() {
		return mAnzahlGetankteLiter;
	}
	/**
	 * Setzt die Anzahl getankter Liter.
	 * @param pAnzahlGetankteLiter
	 *  Die Anzahl getankter Liter
	 */
	public void setAnzahlGetankteLiter(float pAnzahlGetankteLiter) {
		mAnzahlGetankteLiter = pAnzahlGetankteLiter;
	}
	/**
	 * Gibt zurück ob die Tankung abgerechnet ist.
	 * @return
	 *  Ob die Takung abgerechnet ist.
	 */
	public boolean isIstTankungAbgerechhnet() {
		return mIstTankungAbgerechhnet;
	}
	/**
	 * Setzt ob die Takung abgerechnet ist.
	 * @param pIstTankungAbgerechhnet
	 *  Der Wert ob die Tankung abgerechnet ist.
	 */
	public void setIstTankungAbgerechhnet(boolean pIstTankungAbgerechhnet) {
		mIstTankungAbgerechhnet = pIstTankungAbgerechhnet;
	}
	/**
	 * Gibt den Getankten Treibstoffnamen zurück.
	 * @return
	 *  Der Treibstoffname.
	 */
	public String getGetankterTreibstoffBezeichnung() {
		return mGetankterTreibstoffBezeichnung;
	}
	/**
	 * Setzt den getankten Treibstoffbezeichnung
	 * @param pGetankterTreibstoffBezeichnung
	 *  Der Wert der Treibstoffbezeichnung
	 */
	public void setGetankterTreibstoffBezeichnung(
			String pGetankterTreibstoffBezeichnung) {
		mGetankterTreibstoffBezeichnung = pGetankterTreibstoffBezeichnung;
	}
	/**
	 * Gibt das Tankdatum zurück.
	 * @return
	 *  Das Tankdatum.
	 */
	public Date getTankDatum() {
		return mTankDatum;
	}
	/**
	 * Setzt den Wert des Tankdatums.
	 * @param pTankDatum
	 *  Der Wert des Tankdatums.
	 */
	public void setTankDatum(Date pTankDatum) {
		mTankDatum = pTankDatum;
	}
	/**
	 * Gibt den Preis pro Liter zum Tankdatum zurpck.
	 * @return
	 *  Der Preis Pro Liter am Tankdatum.
	 */
	public float getPreisProLiterzuTankdatum() {
		return mPreisProLiterzuTankdatum;
	}
	/**
	 * Setzt den Preis pro Liter zum Tankdatum
	 * @param pPreisProLiterzuTankdatum
	 *  Der Preis Pro Liter am Tankdatum.
	 */
	public void setPreisProLiterzuTankdatum(float pPreisProLiterzuTankdatum) {
		mPreisProLiterzuTankdatum = pPreisProLiterzuTankdatum;
	}
	/**
	 * Gibt die Zapfsäulennummer zurück
	 * @return
	 *  Die Zapfsäulennummer.
	 */
	public int getZapfNummer() {
		return mZapfNummer;
	}
	/**
	 * Setzt den Wert der Zapfsäulennummer.
	 * @param pZapfNummer
	 */
	public void setZapfNummer(int pZapfNummer) {
		mZapfNummer = pZapfNummer;
	}
}
