package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.beobachterMuster;

import static org.junit.Assert.*;

import org.junit.Test;

public class beobachterMusterTest
{
    private Beobachtbar _beobachtbar1;
    private Beobachtbar _beobachtbar2;
    private Beobachter _beobachterA;
    private Beobachter _beobachterB;
    private Beobachter _beobachterC;
    
    public beobachterMusterTest()
    {
        _beobachtbar1 = new Beobachtbar();
        _beobachtbar2 = new Beobachtbar();
        _beobachterA = new Beobachter();
        _beobachterB = new Beobachter();
        _beobachterC = new Beobachter();
        
        _beobachtbar1.registriereBeobachter(_beobachterA);
        _beobachtbar1.registriereBeobachter(_beobachterB);
        _beobachtbar1.registriereBeobachter(_beobachterC);
        
        _beobachtbar2.registriereBeobachter(_beobachterA);
        _beobachtbar2.registriereBeobachter(_beobachterB);
    }
    
    
    @Test
    public void testeAnzahlAufrufeReagiereAufAenderung()
    {
        _beobachtbar1.informiereUeberAenderung();
        assertTrue(_beobachterA.getCounter() == 1);
        assertTrue(_beobachterB.getCounter() == 1);
        assertTrue(_beobachterC.getCounter() == 1);
        
        _beobachtbar1.informiereUeberAenderung();
        _beobachtbar1.informiereUeberAenderung();
        _beobachtbar1.informiereUeberAenderung();
        assertTrue(_beobachterA.getCounter() == 4);
        assertTrue(_beobachterB.getCounter() == 4);
        assertTrue(_beobachterC.getCounter() == 4);
        
        _beobachtbar2.informiereUeberAenderung();
        _beobachtbar2.informiereUeberAenderung();
        assertTrue(_beobachterA.getCounter() == 6);
        assertTrue(_beobachterB.getCounter() == 6);
        assertTrue(_beobachterC.getCounter() == 4);
        
        _beobachtbar1.entferneBeobachter(_beobachterB);
        _beobachtbar1.informiereUeberAenderung();
        _beobachtbar1.informiereUeberAenderung();
        assertTrue(_beobachterA.getCounter() == 8);
        assertTrue(_beobachterB.getCounter() == 6);
        assertTrue(_beobachterC.getCounter() == 6);
        
        
        
    }

}
