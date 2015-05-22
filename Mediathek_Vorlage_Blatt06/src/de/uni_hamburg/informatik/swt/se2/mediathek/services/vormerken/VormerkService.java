package de.uni_hamburg.informatik.swt.se2.mediathek.services.vormerken;

import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Kunde;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Vormerkkarte;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.ObservableService;
import de.uni_hamburg.informatik.swt.se2.mediathek.services.verleih.VerleihService;

/**
 * Der VerleihService erlaubt es, Medien auszuleihen und zurückzugeben.
 * 
 * Für jedes ausgeliehene Medium wird eine neue Verleihkarte angelegt. Wird das
 * Medium wieder zurückgegeben, so wird diese Verleihkarte wieder gelöscht.
 * 
 * VerleihService ist ein ObservableService, als solcher bietet er die
 * Möglichkeit über Verleihvorgänge zu informieren. Beobachter müssen das
 * Interface ServiceObserver implementieren.
 * 
 * @author SE2-Team
 * @version SoSe 2015
 */
public interface VormerkService extends ObservableService {
	boolean istVorgemerkt(Medium medium);

	Vormerkkarte getVormerkkarteFuer(Medium medium);

	void vormerkenAn(Kunde kunde, List<Medium> medien);

	boolean istAusleihbarFuer(List<Medium> medien, Kunde kunde);

	boolean istAusleihbarFuer(Medium medium, Kunde kunde);

	boolean istVorgemerktVon(Medium medium, Kunde kunde);

	boolean istVorgemerktVon(List<Medium> medien, Kunde kunde);

	void setVerleihService(VerleihService verleihService);

	boolean sindVormerkbarVon(List<Medium> medien, Kunde kunde);

	void entferneVormerkkarte(Medium medium);
}