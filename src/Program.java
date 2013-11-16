import java.util.ArrayList;
import java.util.List;

/**
 * Program class.
 */
public class Program {
	
	/**
	 * Main Method
	 * @param args
	 *  Arguments
	 */
	public static void main(String[] args) {
		
		
		Kasse lKasse = new Kasse();
		
		// Initialisiere Daten mit Standardwerten.
		InitializeKasse(lKasse);
	}
	
	private static void InitializeKasse(Kasse pKasse) {
		
		List<Fuellstotzen> lFuellstotzen = new ArrayList<Fuellstotzen>();
		InitializeFuelstotzen(lFuellstotzen);
		
		List<Treibstoff> lTreibstoffe = new ArrayList<Treibstoff>();
		InitializeTreibsotffe(lTreibstoffe, lFuellstotzen);
		
		List<Zapfsaeule> lZapfsaeulen = new ArrayList<Zapfsaeule>();
		InitializeZapfsaeulen(lZapfsaeulen, lFuellstotzen);
		
		pKasse.setZapfsaeulen(lZapfsaeulen);
		pKasse.setTeibstoffe(lTreibstoffe);
	}
	
	private static void InitializeZapfsaeulen(List<Zapfsaeule> pZapfsaeulen, List<Fuellstotzen> pFuellstotzenliste) {
		
		Zapfsaeule lZapfsaeule1 = new Zapfsaeule();
		lZapfsaeule1.setIstTankbar(true);
		lZapfsaeule1.setNummer(1);
		lZapfsaeule1.setFuellstotzenliste(pFuellstotzenliste);
		
		Zapfsaeule lZapfsaeule2 = new Zapfsaeule();
		lZapfsaeule2.setIstTankbar(true);
		lZapfsaeule2.setNummer(2);
		lZapfsaeule2.setFuellstotzenliste(pFuellstotzenliste);
		
		pZapfsaeulen.add(lZapfsaeule1);
		pZapfsaeulen.add(lZapfsaeule2);
	}
	
	private static void InitializeFuelstotzen(List<Fuellstotzen> pFuellstotzenliste) {
		
		Fuellstotzen lFuelstotzen1 = new Fuellstotzen();
		lFuelstotzen1.setIstAbgenommen(false);
		lFuelstotzen1.setMaxFuellung(100);
		lFuelstotzen1.setNummer(1);
		
		Fuellstotzen lFuelstotzen2 = new Fuellstotzen();
		lFuelstotzen2.setIstAbgenommen(false);
		lFuelstotzen2.setMaxFuellung(100);
		lFuelstotzen2.setNummer(2);
		
		pFuellstotzenliste.add(lFuelstotzen1);
		pFuellstotzenliste.add(lFuelstotzen2);
	}

	private static void InitializeTreibsotffe(List<Treibstoff> pTreibstoffe, List<Fuellstotzen> pFuelstotzen) {
		
		List<Treibstofftank> lTreibstofftaenke = new ArrayList<Treibstofftank>();
		InitializelTreibstofftanke(lTreibstofftaenke);
		
		
		Treibstoff lTreibstoff1 = new Treibstoff();
		lTreibstoff1.setBezeichnung("Benzin Bleifrei");
		lTreibstoff1.setPreisProLiter(1.90f);
		lTreibstoff1.setTreibstofftanks(lTreibstofftaenke);
		lTreibstoff1.setFuelstotzen(pFuelstotzen);
		
		Treibstoff lTreibstoff2 = new Treibstoff();
		lTreibstoff2.setBezeichnung("Diesel");
		lTreibstoff2.setPreisProLiter(2.10f);
		lTreibstoff2.setTreibstofftanks(lTreibstofftaenke);
		lTreibstoff2.setFuelstotzen(pFuelstotzen);
		
		pTreibstoffe.add(lTreibstoff1);
		pTreibstoffe.add(lTreibstoff2);
	}
	
	private static void InitializelTreibstofftanke(List<Treibstofftank> pTreibstofftaenke) {
		
		Treibstofftank lTreibstofftank1  = new Treibstofftank();
		lTreibstofftank1.setFuelstand(500);
		lTreibstofftank1.setMaxFuelmenge(1000);
		
		Treibstofftank lTreibstofftank2  = new Treibstofftank();
		lTreibstofftank2.setFuelstand(700);
		lTreibstofftank2.setMaxFuelmenge(1000);
		
		pTreibstofftaenke.add(lTreibstofftank1);
		pTreibstofftaenke.add(lTreibstofftank2);
	}
}
