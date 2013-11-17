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
		
		// Initialisiere Daten mit Standardwerten.
		Kasse lKasse = new Kasse();
		Initialize.Kasse(lKasse);
		
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
		}
	}
}
