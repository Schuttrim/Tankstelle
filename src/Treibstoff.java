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
	
	public List<Fuellstotzen> getFuelstotzen() {
		return mFuelstotzen;
	}
	public void setFuelstotzen(List<Fuellstotzen> pFuelstotzen) {
		mFuelstotzen = pFuelstotzen;
	}
	public List<Treibstofftank> getTreibstofftanks() {
		return mTreibstofftanks;
	}
	public void setTreibstofftanks(List<Treibstofftank> pTreibstofftanks) {
		mTreibstofftanks = pTreibstofftanks;
	}
	public String getBezeichnung() {
		return mBezeichnung;
	}
	public void setBezeichnung(String pBezeichnung) {
		mBezeichnung = pBezeichnung;
	}
	public float getPreisProLiter() {
		return mPreisProLiter;
	}
	public void setPreisProLiter(float pPreisProLiter) {
		mPreisProLiter = pPreisProLiter;
	}
}
