import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
		
		List<Tankung> lTankungen = new ArrayList<Tankung>();
		InitializeTankungen(lTankungen, pKasse);
		
		pKasse.setZapfsaeulen(lZapfsaeulen);
		pKasse.setTeibstoffe(lTreibstoffe);
		pKasse.setTankungen(lTankungen);
		
	}
	
	//@SuppressWarnings("deprecation")
	private static void InitializeTankungen(List<Tankung> pTankungen, Kasse pKasse) {

		Tankung lTankung = new Tankung();
		lTankung.setAnzahlGetankteLiter(40f);
		lTankung.setGetankterTreibstoffBezeichnung("Benzin Bleifrei");
		lTankung.setIstTankungAbgerechhnet(true);
		lTankung.setPreisProLiterzuTankdatum(1.85f);
		
		Calendar lDate = Calendar.getInstance();
		lDate.set(2013, 11, 18, 0, 0, 0);
		
		lTankung.setTankDatum(lDate);
		pTankungen.add(lTankung);
		
		Tankung lTankung1 = new Tankung();
		lTankung1.setAnzahlGetankteLiter(50f);
		lTankung1.setGetankterTreibstoffBezeichnung("Benzin Bleifrei");
		lTankung1.setIstTankungAbgerechhnet(true);
		lTankung1.setPreisProLiterzuTankdatum(1.85f);
		
		Calendar lDate1 = Calendar.getInstance();
		lDate1.set(2013, 11, 18, 23, 59, 59);
		
		lTankung1.setTankDatum(lDate1);
		pTankungen.add(lTankung1);
		
		Tankung lTankung2 = new Tankung();
		lTankung2.setAnzahlGetankteLiter(30f);
		lTankung2.setGetankterTreibstoffBezeichnung("Benzin Bleifrei");
		lTankung2.setIstTankungAbgerechhnet(true);
		lTankung2.setPreisProLiterzuTankdatum(1.85f);
		
		Calendar lDate2 = Calendar.getInstance();
		lDate2.set(2013, 11, 20);
		
		lTankung2.setTankDatum(lDate2);
		pTankungen.add(lTankung2);
		
		Tankung lTankung3 = new Tankung();
		lTankung3.setAnzahlGetankteLiter(45f);
		lTankung3.setGetankterTreibstoffBezeichnung("Diesel");
		lTankung3.setIstTankungAbgerechhnet(true);
		lTankung3.setPreisProLiterzuTankdatum(2.10f);
		
		Calendar lDate3 = Calendar.getInstance();
		lDate3.set(2013, 11, 22);
		
		lTankung3.setTankDatum(lDate3);
		pTankungen.add(lTankung3);
		
		Tankung lTankung4 = new Tankung();
		lTankung4.setAnzahlGetankteLiter(35f);
		lTankung4.setGetankterTreibstoffBezeichnung("Diesel");
		lTankung4.setIstTankungAbgerechhnet(true);
		lTankung4.setPreisProLiterzuTankdatum(2.10f);
		
		Calendar lDate4 = Calendar.getInstance();
		lDate4.set(2013, 11, 22);
		
		lTankung4.setTankDatum(lDate4);
		pTankungen.add(lTankung4);
		
		Tankung lTankung5 = new Tankung();
		lTankung5.setAnzahlGetankteLiter(60f);
		lTankung5.setGetankterTreibstoffBezeichnung("Benzin Bleifrei");
		lTankung5.setIstTankungAbgerechhnet(true);
		lTankung5.setPreisProLiterzuTankdatum(1.80f);
		
		Calendar lDate5 = Calendar.getInstance();
		lDate5.set(2013, 11, 23);
		
		lTankung5.setTankDatum(lDate5);
		pTankungen.add(lTankung5);
		
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
				lFuelstotzen1.setMaxFuellung(200);
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
		lTreibstoff1.setPreisProLiter(1.81f);
		lTreibstoff1.setTreibstofftanks(lTreibstofftaenke);
		//lTreibstoff1.setFuelstotzen(pFuelstotzen);
		
		Treibstoff lTreibstoff2 = new Treibstoff();
		lTreibstoff2.setBezeichnung("Diesel");
		lTreibstoff2.setPreisProLiter(1.98f);
		lTreibstoff2.setTreibstofftanks(lTreibstofftaenke);
		//lTreibstoff2.setFuelstotzen(pFuelstotzen);
		
		Treibstoff lTreibstoff3 = new Treibstoff();
		lTreibstoff3.setBezeichnung("Super");
		lTreibstoff3.setPreisProLiter(2.01f);
		lTreibstoff3.setTreibstofftanks(lTreibstofftaenke);
		
		pTreibstoffe.add(lTreibstoff1);
		pTreibstoffe.add(lTreibstoff2);
		pTreibstoffe.add(lTreibstoff3);
	}
	
	private static void InitializeTreibstofftanke(List<Treibstofftank> pTreibstofftaenke) {
		
		Treibstofftank lTreibstofftank1  = new Treibstofftank();
		lTreibstofftank1.setMaxFuelmenge(1000f);
		lTreibstofftank1.setFuelstand(1000f);
		
		Treibstofftank lTreibstofftank2  = new Treibstofftank();
		lTreibstofftank2.setMaxFuelmenge(100000f);
		lTreibstofftank2.setFuelstand(20000f);
		
		pTreibstofftaenke.add(lTreibstofftank1);
		pTreibstofftaenke.add(lTreibstofftank2);
	}
}
