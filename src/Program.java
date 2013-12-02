
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
		lKasse.getTankstelle().printPreisTafel();
		
		Zapfsaeule lAusgewaehlteZapfsaeule = null;
		for (Zapfsaeule lZapfsaeule : lKasse.getTankstelle().getZapfsaeulen()) {
			
			if (lZapfsaeule.getNummer() == 1) {
				
				lAusgewaehlteZapfsaeule = lZapfsaeule;
			}
		}
		
		if (lAusgewaehlteZapfsaeule != null) {
			
			lAusgewaehlteZapfsaeule.fuellstotzenAbnehmen(1);
			lAusgewaehlteZapfsaeule.tanken(72f);
			lAusgewaehlteZapfsaeule.fuellstotzenAuflegen();
			
			lKasse.tankungBezahlen(1);
			
			lAusgewaehlteZapfsaeule.fuellstotzenAbnehmen(1);
			lAusgewaehlteZapfsaeule.tanken(150f);
			lAusgewaehlteZapfsaeule.fuellstotzenAuflegen();
			
			lKasse.tankungBezahlen(1);
			
			lAusgewaehlteZapfsaeule.fuellstotzenAbnehmen(0);
			lAusgewaehlteZapfsaeule.tanken(20f);
			lAusgewaehlteZapfsaeule.fuellstotzenAuflegen();
			
			lKasse.tankungBezahlen(1);
			
			lAusgewaehlteZapfsaeule.fuellstotzenAbnehmen(0);
			lAusgewaehlteZapfsaeule.tanken(76f);
			lAusgewaehlteZapfsaeule.fuellstotzenAuflegen();
			
			lKasse.tankungBezahlen(1);
			
			
			Calendar lVon = Calendar.getInstance();
			lVon.set(2013, 11, 2);
			
			Calendar lBis = Calendar.getInstance();
			lBis.set(2013, 11, 2);
				
			lKasse.auswerten(lVon, lBis);
	
		}
	}
}
