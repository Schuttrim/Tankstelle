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
	 * Gibt die F�lstotzen zur�ck.
	 * @return
	 *  Die F�llstotzen.
	 */
	public List<Fuellstotzen> getFuelstotzen() {
		return mFuelstotzen;
	}
	/**
	 * Setzt die F�llstotzen.
	 * @param pFuelstotzen
	 *  Der Wert der F�llstotzen.
	 */
	public void setFuelstotzen(List<Fuellstotzen> pFuelstotzen) {
		mFuelstotzen = pFuelstotzen;
	}
	/**
	 * Gibt die Treibsstofftanks zur�ck.
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
	 * Gibt die Bezeichnung zur�ck.
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
	 * Gibt den Preis pro Liter zur�ck.
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
