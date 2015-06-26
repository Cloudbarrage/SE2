package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

/**
 * Interface für Beobachter, die sich für Änderungen eines ObservableSubWerkzeug
 * interessieren.
 */
public interface SubWerkzeugObserver
{
    /**
     * Diese Operation wird aufgerufen, sobald sich an an dem beobachteten
     * Werkzeug etwas relevantes geändert hat.
     * 
     * Implementierende Klassen müssen in dieser Operation auf die Aenderung
     * reagieren.
     * 
     * @param w - Das Subwerkzeug welches reagiere auf Änderung aufruft.
     * 
     */
	//TODO: annonyme Klassen
    void reagiereAufAenderung(ObservableSubWerkzeug w);
}