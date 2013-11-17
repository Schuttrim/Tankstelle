import java.util.ArrayList;
import java.util.List;

/**
 * Stellt einen Treibstoff dar.
 */
public class Treibstoff {
	
	private String mBezeichnung;
	private float mPreisProLiter;
	List<Fuellstotzen> mFuelstotzen = new ArrayList<Fuellstotzen>();
	List<Treibstofftank> mTreibstofftanks = new ArrayList<Treibstofftank>();
	
	/**
	 * Gibt die Fülstotzen zurück.
	 * @return
	 *  Die Füllstotzen.
	 */
	public List<Fuellstotzen> getFuelstotzen() {
		return mFuelstotzen;
	}
	/**
	 * Setzt die Füllstotzen.
	 * @param pFuelstotzen
	 *  Der Wert der Füllstotzen.
	 */
	public void setFuelstotzen(List<Fuellstotzen> pFuelstotzen) {
		mFuelstotzen = pFuelstotzen;
	}
	/**
	 * Gibt die Treibsstofftanks zurück.
	 * @return
	 *  Die Treibstofftanks.
	 */
	public List<Treibstofftank> getTreibstofftanks() {
		return mTreibstofftanks;
	}
	/**
	 * Setzt den Wert der Treibstofftanks.
	 * @param pTreibstofftanks
	 *  Der Wert der Treibstofftanks.
	 */
	public void setTreibstofftanks(List<Treibstofftank> pTreibstofftanks) {
		mTreibstofftanks = pTreibstofftanks;
	}
	/**
	 * Gibt die Bezeichnung zurück.
	 * @return
	 *  Die Bezeichnung
	 */
	public String getBezeichnung() {
		return mBezeichnung;
	}
	/**
	 * Setzt die Bezeichnung.
	 * @param pBezeichnung
	 *  Der Wert der Bezeeichnung.
	 */
	public void setBezeichnung(String pBezeichnung) {
		mBezeichnung = pBezeichnung;
	}
	/**
	 * Gibt den Preis pro Liter zurück.
	 * @return
	 *  Der Preis pro liter.
	 */
	public float getPreisProLiter() {
		return mPreisProLiter;
	}
	/**
	 * Sezt den Preis pro Liter.
	 * @param pPreisProLiter
	 *  Der Preis pro Liter.
	 */
	public void setPreisProLiter(float pPreisProLiter) {
		mPreisProLiter = pPreisProLiter;
	}
}
