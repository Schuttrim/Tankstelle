
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		
		// Initialisiere Daten mit Standardwerten.
		Kasse lKasse = new Kasse();
		Initialize.Kasse(lKasse);
		lKasse.printPreisTafel();
		
		Zapfsaeule lAusgewaehlteZapfsaeule = null;
		for (Zapfsaeule lZapfsaeule : lKasse.getZapfsaeulen()) {
			
			if (lZapfsaeule.getNummer() == 1) {
				
				lAusgewaehlteZapfsaeule = lZapfsaeule;
			}
		}
		
		if (lAusgewaehlteZapfsaeule != null) {
			
			lAusgewaehlteZapfsaeule.fuellstotzenAbnehmen(1);
			lAusgewaehlteZapfsaeule.tanken(45.25f);
			lAusgewaehlteZapfsaeule.fuellstotzenAuflegen();
			lAusgewaehlteZapfsaeule.fuellstotzenAuflegen();
			
			lKasse.tankungBezahlen(1);
			lKasse.tankungBezahlen(1);
			
			System.out.println(40f*1.85f+50f*1.85f+30f*1.85f+45f*2.1f+35f*2.1f+60f*1.8f+45.25f*2.1f);
			
			Calendar lVon = Calendar.getInstance();
			lVon.set(2013, 10, 1);
			
			Calendar lBis = Calendar.getInstance();
			lBis.set(2013, 11, 30);
				
			lKasse.auswerten(lVon, lBis);
	
		}
	}
}
