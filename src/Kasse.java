import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Lt;

/**
 * Stellt eine Kasse dar.
 */
public class Kasse {
	
	private List<Treibstoff> mTeibstoffe = new ArrayList<Treibstoff>();
	private List<Tankung> mTankungen = new ArrayList<Tankung>();
	private List<Zapfsaeule> mZapfsaeulen = new ArrayList<Zapfsaeule>();
	
	
	
	public List<Treibstoff> getTeibstoffe() {
		return mTeibstoffe;
	}

	public void setTeibstoffe(List<Treibstoff> pTeibstoffe) {
		mTeibstoffe = pTeibstoffe;
	}

	public List<Tankung> getTankungen() {
		return mTankungen;
	}

	public void setTankungen(List<Tankung> pTankungen) {
		mTankungen = pTankungen;
	}

	public List<Zapfsaeule> getZapfsaeulen() {
		return mZapfsaeulen;
	}

	public void setZapfsaeulen(List<Zapfsaeule> pZapfsaeulen) {
		mZapfsaeulen = pZapfsaeulen;
	}
	
	
	

	public void tankungBezahlen(int pZapfsaeuleNummer) {
		
	}
	
	public void auswerten(Date pVon, Date pBis) {
		
	}
	
	public void printPreisTafel() {
		
	}
	
	public void neueTankung(int pZapfnr, float pLiter, String pTreibstoff) {
		
		Tankung lTankung = new Tankung();
		lTankung.setAnzahlGetankteLiter(pLiter);
		lTankung.setGetankterTreibstoffBezeichnung(pTreibstoff);
		lTankung.setIstTankungAbgerechhnet(false);
		lTankung.setTankDatum(new Date());
		lTankung.setZapfNummer(pZapfnr);
		
		for (Treibstoff lTreibstoff : mTeibstoffe) {
			
			if (lTreibstoff.getBezeichnung() == pTreibstoff) {
				
				lTankung.setPreisProLiterzuTankdatum(lTreibstoff.getPreisProLiter());
			}
		}
		
		mTankungen.add(lTankung);
	}
	
}
