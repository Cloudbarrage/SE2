package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.LinkedList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkKarte
{
    private Medium _medium;
    private List<Kunde> _vormerker;

    /**
     * @param medium Das Medium, das zu einer VormerkungsKarte gehört.
     * 
     * @require medium != null
     */
    public VormerkKarte(Medium medium)
    {
        assert medium != null : "Vorbedingung verletzt";
        _medium = medium;
        _vormerker = new LinkedList<Kunde>();
    }

    /**
     * @param kunde Ein Kunde, für den getestet werden soll, ob es sich um den ersten Vormerker handelt.
     * 
     * @return true or false
     * 
     * @require kunde != null
     */
    public boolean istErsterVormerker(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt";
        if (getAnzahlVormerkungen() > 0)
        {
            return (kunde.equals(_vormerker.get(0)));
        }
        return false;
    }

    /**
     * @return true or false
     */
    public boolean istMaximaleAnzahlVormerkerErreicht()
    {
        return (_vormerker.size() >= 3);
    }

    /**
     * @param kunde Ein Kunde, für den getestet werden soll, ob er das medium schon einmal vorgemerkt hat.
     * @return true or false
     * @require kunde != null
     */
    public boolean hatKundeSchonVorgemerkt(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt";
        boolean vorgemerkt = false;
        for (Kunde kundeInListe : _vormerker)
        {
            if (kunde.getKundennummer() == (kundeInListe.getKundennummer()))
            {
                vorgemerkt = true;
            }
        }
        return vorgemerkt;
    }

    /**
     * @param kunde Ein Kunde, der vormerken möchte bzw. vorgemerkt werden soll.
     * @return true or false
     * @require kunde != null
     */
    public boolean istVormerkenMoeglich(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt";
        return (!istMaximaleAnzahlVormerkerErreicht() && !hatKundeSchonVorgemerkt(kunde));
    }

    /**
     * @param kunde Ein Kunde, der in die Vormerkschlange eingefügt werden soll.
     * @require kunde != null 
     */
    public void fuegeKundeHinzu(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt";
        _vormerker.add(kunde);
    }

    /**
     * @return int Die Anzahl an Vormerkungen in einer Vormerkschlange.
     */
    public int getAnzahlVormerkungen()
    {
        return _vormerker.size();
    }

    /**
     * @return Medium Das Medium, das zur Vormerkschlange gehört.
     */
    public Medium getMedium()
    {
        return _medium;
    }

    /**
     * @return List<Kunde> Die Vormerkschlange.
     */
    public List<Kunde> getVermerkListe()
    {
        return _vormerker;
    }
    
    /**
     * Entfernt den ersten Vormerker aus der Vormerkliste.
     */
    public void entferneErsteVormerkung()
    {
        _vormerker.remove(0);
    }

    /**
     * @return Kunde Gibt den Vormerker an Position x innerhalb der Vormerkschlange zurück.
     * @require x < 3
     * @require x >= 0
     */
    public Kunde getVormerkerAnPosition(int x)
    {
        assert x >= 0 : "Vorbedingung verletzt";
        Kunde vormerkerBeiX = null;
        if (getAnzahlVormerkungen() >= (x + 1))
        {
            vormerkerBeiX = _vormerker.get(x);
        }
        return vormerkerBeiX;
    }
}
