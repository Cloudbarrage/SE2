package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

/**
 * Interface für Beobachter, die sich für Änderungen eines ObservableWerkzeug
 * interessieren.
 * 
 * @author SE2-Team
 * @version SoSe 2015
 */
public interface WerkzeugObserver
{
    /**
     * Diese Operation wird aufgerufen, sobald sich an an dem beobachteten
     * Werkzeug etwas relevantes geändert hat.
     * 
     * Implementierende Klassen müssen in dieser Operation auf die Aenderung
     * reagieren.
     */
    void reagiereAufAenderung(Object o);
}
