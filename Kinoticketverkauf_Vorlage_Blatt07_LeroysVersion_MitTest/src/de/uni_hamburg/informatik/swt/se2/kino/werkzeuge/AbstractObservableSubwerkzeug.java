package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import java.util.ArrayList;
import java.util.List;

/**
 * Eine abstrakt Implementation des ObservableWerkzeug Interfaces, die die
 * Verwaltung und Benachrichtigung der Beobachter bereitstellt.
 * 
 * @author SE2-Team
 * @version SoSe 2015
 */
public abstract class AbstractObservableSubwerkzeug implements ObservableSubwerkzeug
{

    /**
     * Die Liste der registrierten Beobachter.
     */
    private List<WerkzeugObserver> _beobachterListe;

    /**
     * Initialisiert einen neuen AbstractObservableService.
     */
    public AbstractObservableSubwerkzeug()
    {
        _beobachterListe = new ArrayList<WerkzeugObserver>();
    }

    @Override
    public void registriereBeobachter(WerkzeugObserver beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter != null";
        if (!_beobachterListe.contains(beobachter))
        {
            _beobachterListe.add(beobachter);
        }
    }

    @Override
    public void entferneBeobachter(WerkzeugObserver beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter != null";
        _beobachterListe.remove(beobachter);
    }

    /**
     * Informiert alle angemeldeten Beobachter dass eine relevante Änderung
     * eingetreten ist.
     */
    public void informiereUeberAenderung()
    {
        for (WerkzeugObserver beobachter : _beobachterListe)
        {
            beobachter.reagiereAufAenderung(this);
        }
    }
}

