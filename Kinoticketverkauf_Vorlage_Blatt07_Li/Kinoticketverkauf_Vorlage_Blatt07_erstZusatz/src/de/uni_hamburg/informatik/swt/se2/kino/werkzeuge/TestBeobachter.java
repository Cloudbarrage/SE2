package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

public class TestBeobachter implements SubwerkzeugObserver
{
    private int _aufrufAnzahl;
    
    @Override   
    public void reagiereAufAenderung()
    {
        ++_aufrufAnzahl;
    }
    
    public int gibAnzahl()
    {
        return _aufrufAnzahl;
    }
}
