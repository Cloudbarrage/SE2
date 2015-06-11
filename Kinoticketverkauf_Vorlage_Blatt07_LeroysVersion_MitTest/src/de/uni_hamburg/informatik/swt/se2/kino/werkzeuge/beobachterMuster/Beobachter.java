package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.beobachterMuster;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.WerkzeugObserver;

public class Beobachter implements WerkzeugObserver
{

    int _counter = 0;
    
    @Override
    public void reagiereAufAenderung(Object o)
    {
        ++_counter;
    }

    public int getCounter()
    {
        return _counter;
    }
}
