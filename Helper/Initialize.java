import java.util.ArrayList;
import java.util.List;

/**
 * Stellt eine Inititialize Klasse dar.
 */
public class Initialize {
	
	/**
	 * Initialisiert eine Kasse mit Standarddaten
	 * @param pKasse
	 *  Die zu initialisierende Kasse
	 */
	public static void Kasse(Kasse pKasse) {
		
		List<Zapfsaeule> lZapfsaeulen = new ArrayList<Zapfsaeule>();
		InitializeZapfsaeulen(lZapfsaeulen, pKasse);
		
		List<Treibstoff> lTreibstoffe = new ArrayList<Treibstoff>();
		InitializeTreibsotffe(lTreibstoffe);
		
		List<Fuellstotzen> lFuellstotzen = new ArrayList<Fuellstotzen>();
		InitializeFuelstotzen(lFuellstotzen, lZapfsaeulen, lTreibstoffe);
		
		pKasse.setZapfsaeulen(lZapfsaeulen);
		pKasse.setTeibstoffe(lTreibstoffe);
	}
	
	private static void InitializeZapfsaeulen(List<Zapfsaeule> pZapfsaeulen, Kasse pKasse) {
		
		Zapfsaeule lZapfsaeule1 = new Zapfsaeule();
		lZapfsaeule1.setIstTankbar(true);
		lZapfsaeule1.setNummer(1);
		lZapfsaeule1.setKasse(pKasse);
		//lZapfsaeule1.setFuellstotzenliste(pFuellstotzenliste);
		
		Zapfsaeule lZapfsaeule2 = new Zapfsaeule();
		lZapfsaeule2.setIstTankbar(true);
		lZapfsaeule2.setNummer(2);
		lZapfsaeule2.setKasse(pKasse);
		//lZapfsaeule2.setFuellstotzenliste(pFuellstotzenliste);
		
		pZapfsaeulen.add(lZapfsaeule1);
		pZapfsaeulen.add(lZapfsaeule2);
	}
	
	private static void InitializeFuelstotzen(List<Fuellstotzen> pFuellstotzenliste, 
			List<Zapfsaeule> pZapfsaeulen, List<Treibstoff> pTreibstoffe) {
		
		// Es wird für jede zapfsäule 1 fülstotzen mit je 1 Treibstoff erstellt.
		for (Zapfsaeule lZapfsaeule : pZapfsaeulen) {
			
			List<Fuellstotzen> lZapfsaeulenFuelstotzen = new ArrayList<Fuellstotzen>();
			
			int lStotzenNummer = 0;
			for (Treibstoff lTreibstoff : pTreibstoffe) {
				
				Fuellstotzen lFuelstotzen1 = new Fuellstotzen();
				lFuelstotzen1.setIstAbgenommen(false);
				lFuelstotzen1.setMaxFuellung(100);
				lFuelstotzen1.setNummer(lStotzenNummer++);
				lFuelstotzen1.setZapfsaeule(lZapfsaeule);
				lFuelstotzen1.setTreibstoff(lTreibstoff);
				
				lZapfsaeulenFuelstotzen.add(lFuelstotzen1);
				pFuellstotzenliste.add(lFuelstotzen1);
				
				List<Fuellstotzen> lFuelstotzenlist = lTreibstoff.getFuelstotzen();
				lFuelstotzenlist.add(lFuelstotzen1);
				lTreibstoff.setFuelstotzen(lFuelstotzenlist);
				
			}
			//Fuellstotzen lFuelstotzen1 = new Fuellstotzen();
			//lFuelstotzen1.setIstAbgenommen(false);
			//lFuelstotzen1.setMaxFuellung(100);
			//lFuelstotzen1.setNummer(1);
			//lFuelstotzen1.setZapfsaeule(lZapfsaeule);
			
			//Fuellstotzen lFuelstotzen2 = new Fuellstotzen();
			//lFuelstotzen2.setIstAbgenommen(false);
			//lFuelstotzen2.setMaxFuellung(100);
			//lFuelstotzen2.setNummer(2);
			//lFuelstotzen2.setZapfsaeule(lZapfsaeule);
			
			//pFuellstotzenliste.add(lFuelstotzen1);
			//pFuellstotzenliste.add(lFuelstotzen2);
			
			//lZapfsaeulenFuelstotzen.add(lFuelstotzen1);
			//lZapfsaeulenFuelstotzen.add(lFuelstotzen2);
			
			lZapfsaeule.setFuellstotzenliste(lZapfsaeulenFuelstotzen);
		}
	}

	private static void InitializeTreibsotffe(List<Treibstoff> pTreibstoffe) {
		
		List<Treibstofftank> lTreibstofftaenke = new ArrayList<Treibstofftank>();
		InitializeTreibstofftanke(lTreibstofftaenke);
		
		
		Treibstoff lTreibstoff1 = new Treibstoff();
		lTreibstoff1.setBezeichnung("Benzin Bleifrei");
		lTreibstoff1.setPreisProLiter(1.90f);
		lTreibstoff1.setTreibstofftanks(lTreibstofftaenke);
		//lTreibstoff1.setFuelstotzen(pFuelstotzen);
		
		Treibstoff lTreibstoff2 = new Treibstoff();
		lTreibstoff2.setBezeichnung("Diesel");
		lTreibstoff2.setPreisProLiter(2.10f);
		lTreibstoff2.setTreibstofftanks(lTreibstofftaenke);
		//lTreibstoff2.setFuelstotzen(pFuelstotzen);
		
		pTreibstoffe.add(lTreibstoff1);
		pTreibstoffe.add(lTreibstoff2);
	}
	
	private static void InitializeTreibstofftanke(List<Treibstofftank> pTreibstofftaenke) {
		
		Treibstofftank lTreibstofftank1  = new Treibstofftank();
		lTreibstofftank1.setMaxFuelmenge(1000f);
		lTreibstofftank1.setFuelstand(500f);
		
		Treibstofftank lTreibstofftank2  = new Treibstofftank();
		lTreibstofftank2.setMaxFuelmenge(1000f);
		lTreibstofftank2.setFuelstand(700f);
		
		pTreibstofftaenke.add(lTreibstofftank1);
		pTreibstofftaenke.add(lTreibstofftank2);
	}
}
