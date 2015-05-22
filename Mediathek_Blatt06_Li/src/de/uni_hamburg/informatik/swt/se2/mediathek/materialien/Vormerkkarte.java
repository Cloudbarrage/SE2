package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;



import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



public class Vormerkkarte
{   
    /**
     * Das VormerkersList, in dem drei Vormerkers speichert werden
     * durch Queue realisiert
     */
    private BlockingQueue<Kunde> _vormerkerListe;
    
    /**
     * Initialisert eine neue Vormerkkarte mit angegebene Medium
     * 
     * @param medium entsprechend Medium
     * 
     * @require medium != null
     */
    public Vormerkkarte()
    {
        _vormerkerListe = new LinkedBlockingQueue<Kunde>(3);
    }
    
    /**
     * Fuegen ein Neu Vormerker ein
     * 
     * @param kunde der Vormerker
     * @return 
     * 
     * @require kunde != null
     * @require 
     */
    public void fuegenVormerkerEin(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt: medium != null";
        
        if(!istMediumVollgemerkt())
        {
            _vormerkerListe.add(kunde);;
        }
        
    }
    
    /**
     * Pruefen, ob Kunde diese Medium schon vorgemerkt hat
     * 
     * @param kunde 
     * @return true,wenn Kunde ist einer der Vormerkers
     */
    public boolean istVormerkerInSchlange(Kunde kunde)
    {
        return _vormerkerListe.contains(kunde);
    }
    
    /**
     * Pruefen, ob im List schon drei Vormerkers stehen
     * 
     * @return true, wenn es drei Vormerkers gibt
     */
    public boolean istMediumVollgemerkt()
    {
        return _vormerkerListe.size() == 3;
    }
    
    
    /**
     * Pruefen, ob Entleiher der ersten Vormerker ist
     * 
     * @param kunde Entleiher, der diese Medium entleihen moechte
     * @return true,wenn Kunde ist genau der ersten Vormerker
     */
    public boolean istKundeErstVormerker(Kunde kunde)
    {
        return _vormerkerListe.peek().equals(kunde);
    }
    
    
    /**
     * Nach dem Ausleih verschieben Vormerkers nach vorne
     */
    public void vormerkersNachVorneVerschiben()
    {
        if(_vormerkerListe.size()>=1)
        {
            _vormerkerListe.remove();
        }
    }
    
    /**
     * Liefert Vormerker an angegebne Stelle zurueck
     * 
     * @param stelle index of Kunde Array
     * @return Kunde , die in angegebene Stelle steht
     */
    public Kunde getVormerkerAufStelle(int stelle)
    {
        assert stelle <= 2 : "Vorbedingung verletzt: medium != null";
        
        if(_vormerkerListe.size()-1 >= stelle)
        {
            Kunde[] stringlist = _vormerkerListe.toArray(new Kunde[0]);
            return stringlist[stelle];
        }
        else
        {
            return null;
        }
    }
    
    public boolean istMediumVorgemerkt()
    {
        return _vormerkerListe.size() != 0;
    }
}
