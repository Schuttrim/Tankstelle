import java.util.ArrayList;
import java.util.List;

/**
 * stellt eine tankstelle dar
 */
public class Tankstelle {
	private List<Treibstoff> mTeibstoffe = new ArrayList<Treibstoff>();
	private List<Tankung> mTankungen = new ArrayList<Tankung>();
	private List<Zapfsaeule> mZapfsaeulen = new ArrayList<Zapfsaeule>();
	private Kasse mKasse;
	
	/**
	 * Gibt die Kasse zurück.
	 * @return
	 * Die Kasse
	 */
	public Kasse getKasse() {
		return mKasse;
	}
	
	/**
	 * Setzt den Wert der Kasse
	 * @param pKasse
	 */
	public void setKasse(Kasse pKasse) {
		this.mKasse = pKasse;
		mKasse.setTankstelle(this);
	}
	

	/**
	 * Gibt die Treibstoffe zurück
	 * @return
	 *  Die Treibstoffe.
	 */
	public List<Treibstoff> getTeibstoffe() {
		return mTeibstoffe;
	}

	/**
	 * Setzt die Treibstoffe
	 * @param pTeibstoffe
	 *  Der Wert der Treibstoffe.
	 */
	public void setTeibstoffe(List<Treibstoff> pTeibstoffe) {
		mTeibstoffe = pTeibstoffe;
	}
	
	/**
	 * Gibt die Tankungen zurück
	 * @return
	 *  Die Tankunge.
	 */
	public List<Tankung> getTankungen() {
		return mTankungen;
	}

	/**
	 * Setzt die Tankungen
	 * @param pTankungen
	 *  Der Wert der Tankungen
	 */
	public void setTankungen(List<Tankung> pTankungen) {
		mTankungen = pTankungen;
	}
	
	public void addTankung(Tankung pTankung) {
		mTankungen.add(pTankung);
	}

	/**
	 * Gibt die Zapfsäulen zurück.
	 * @return
	 *  Die Zapfsäulen.
	 */
	public List<Zapfsaeule> getZapfsaeulen() {
		return mZapfsaeulen;
	}

	/**
	 * Setzt den Wert der Zapfsäulen
	 * @param pZapfsaeulen
	 *  Den Wert der Zapfsäulen.
	 */
	public void setZapfsaeulen(List<Zapfsaeule> pZapfsaeulen) {
		mZapfsaeulen = pZapfsaeulen;
		for (Zapfsaeule lZapfsaeule : mZapfsaeulen) {
			lZapfsaeule.setTankstelle(this);
		}
	}
	
	/**
	 * Gibt die Preise aller Treibstoffe auf dem Bilschirm aus.
	 */
	public void printPreisTafel() {
		System.out.println("\nDie aktuellen Preise sind:");
		
		for (Treibstoff lTreibstoff : mTeibstoffe){
			System.out.format(" - %s: %4.2f Fr.\n", lTreibstoff.getBezeichnung(), lTreibstoff.getPreisProLiter());
		}
		
		System.out.println();
	}
}
