package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge;

import static org.junit.Assert.*;

import org.junit.Test;

public class BeobachtermusterTest
{
    private TestBeobachtbar _testbeobachtbar;
    private TestBeobachter _testbeobachter1;
    private TestBeobachter _testbeobachter2;
    
    public BeobachtermusterTest()
    {
        _testbeobachtbar = new TestBeobachtbar();
        _testbeobachter1 = new TestBeobachter();
        _testbeobachter2 = new TestBeobachter();
    }
    
    @Test
    public void testAnzahl()
    {
        _testbeobachtbar.registriereBeobachter(_testbeobachter1);
        _testbeobachtbar.registriereBeobachter(_testbeobachter2);
        _testbeobachtbar.informiereUeberAenderung();
        
        assertEquals(_testbeobachter1.gibAnzahl(),1);
        assertEquals(_testbeobachter2.gibAnzahl(),1);
        
        _testbeobachtbar.informiereUeberAenderung();
        _testbeobachtbar.informiereUeberAenderung();
        
        assertEquals(_testbeobachter1.gibAnzahl(),3);
        assertEquals(_testbeobachter2.gibAnzahl(),3);
    }

}
