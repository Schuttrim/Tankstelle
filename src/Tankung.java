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
	
	
	
	public float getAnzahlGetankteLiter() {
		return mAnzahlGetankteLiter;
	}
	public void setAnzahlGetankteLiter(float pAnzahlGetankteLiter) {
		mAnzahlGetankteLiter = pAnzahlGetankteLiter;
	}
	public boolean isIstTankungAbgerechhnet() {
		return mIstTankungAbgerechhnet;
	}
	public void setIstTankungAbgerechhnet(boolean pIstTankungAbgerechhnet) {
		mIstTankungAbgerechhnet = pIstTankungAbgerechhnet;
	}
	public String getGetankterTreibstoffBezeichnung() {
		return mGetankterTreibstoffBezeichnung;
	}
	public void setGetankterTreibstoffBezeichnung(
			String pGetankterTreibstoffBezeichnung) {
		mGetankterTreibstoffBezeichnung = pGetankterTreibstoffBezeichnung;
	}
	public Date getTankDatum() {
		return mTankDatum;
	}
	public void setTankDatum(Date pTankDatum) {
		mTankDatum = pTankDatum;
	}
	public float getPreisProLiterzuTankdatum() {
		return mPreisProLiterzuTankdatum;
	}
	public void setPreisProLiterzuTankdatum(float pPreisProLiterzuTankdatum) {
		mPreisProLiterzuTankdatum = pPreisProLiterzuTankdatum;
	}
	public int getZapfNummer() {
		return mZapfNummer;
	}
	public void setZapfNummer(int pZapfNummer) {
		mZapfNummer = pZapfNummer;
	}
}
