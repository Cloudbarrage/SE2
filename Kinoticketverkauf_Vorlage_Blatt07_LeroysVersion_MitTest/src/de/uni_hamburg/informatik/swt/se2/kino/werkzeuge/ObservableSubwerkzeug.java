package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

/**
 * Das interface für beobachtbare Services. Definiert Operationen zum An- und
 * Abmelden von Beobachtern.
 * 
 * @author SE2-Team
 * @version SoSe 2015
 */
public interface ObservableSubwerkzeug
{

    /**
     * Meldet den gegebenen Beoabachter beim an.
     * 
     * @param beobachter Ein Beobachter, der angemeldet werden soll.
     * 
     * @require beobachter != null
     */
    void registriereBeobachter(WerkzeugObserver beobachter);

    /**
     * Meldet den gegebenen Beoabachter beim ab.
     * 
     * @param beobachter Ein Beobachter, der abgemeldet werden soll.
     * 
     * @require beobachter != null
     */
    void entferneBeobachter(WerkzeugObserver beobachter);
}
