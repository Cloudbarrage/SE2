
package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.*;
import org.junit.Test;


public class GeldbetragTest
{
    private Geldbetrag a = Geldbetrag.valueOf(15, 0);
    private Geldbetrag b = Geldbetrag.valueOf(2, 99);
    private Geldbetrag c = Geldbetrag.valueOf(-2, 59);
    private Geldbetrag d = Geldbetrag.valueOf(10, -222);
    private Geldbetrag e = Geldbetrag.valueOf(-10, -222);
    private Geldbetrag f = Geldbetrag.valueOf(17, -88);
    
    @Test
    public void testeValueOf()
    {
        assertEquals(15, Geldbetrag.valueOf(15, 99).euroAnteil());
        assertEquals(99, Geldbetrag.valueOf(15, 99).centAnteil());
        
        assertEquals(-1, c.euroAnteil());
        assertEquals(-41, c.centAnteil());
        
        assertEquals(7, d.euroAnteil());
        assertEquals(78, d.centAnteil());
        
        assertEquals(-12, e.euroAnteil());
        assertEquals(-22, e.centAnteil());
    }
    
    @Test
    public void testeSumme()
    {
        assertEquals(17, a.berechneSummeMit(b).euroAnteil());
        assertEquals(99, a.berechneSummeMit(b).centAnteil());
        
        assertEquals(5, b.berechneSummeMit(b).euroAnteil());
        assertEquals(98, b.berechneSummeMit(b).centAnteil());
        
        assertEquals(-2, c.berechneSummeMit(c).euroAnteil());
        assertEquals(-82, c.berechneSummeMit(c).centAnteil());
        
        assertEquals(22, a.berechneSummeMit(d).euroAnteil());
        assertEquals(78, a.berechneSummeMit(d).centAnteil());
        
        assertEquals(2, a.berechneSummeMit(e).euroAnteil());
        assertEquals(78, a.berechneSummeMit(e).centAnteil());
    }
    
    @Test
    public void testeDifferenz()
    {
        assertEquals(12, a.subtrahiere(b).euroAnteil());
        assertEquals(1, a.subtrahiere(b).centAnteil());
        
        assertEquals(0, b.subtrahiere(b).euroAnteil());
        assertEquals(0, b.subtrahiere(b).centAnteil());
        
        assertEquals(7, a.subtrahiere(d).euroAnteil());
        assertEquals(22, a.subtrahiere(d).centAnteil());
        
        assertEquals(-1, a.subtrahiere(f).euroAnteil());
        assertEquals(-12, a.subtrahiere(f).centAnteil());
    }
    
    @Test
    public void testeMultiplikation()
    {
        assertEquals(75, a.multipliziereMit(5).euroAnteil());
        assertEquals(0, a.multipliziereMit(5).centAnteil());
        
        assertEquals(-2, c.multipliziereMit(2).euroAnteil());
        assertEquals(-82, c.multipliziereMit(2).centAnteil());
        
        assertEquals(-30, a.multipliziereMit(-2).euroAnteil());
        assertEquals(0, a.multipliziereMit(-2).centAnteil());
    }
    
    @Test
    public void testeStringToGeldbetrag()
    {
        assertEquals(-12, Geldbetrag.stringToGeldbetrag("-10,-222€").euroAnteil());
        assertEquals(-22, Geldbetrag.stringToGeldbetrag("-10,-222€").centAnteil());
    }
    
    @Test
    public void testeIntegerToGeldbetrag()
    {
        assertEquals(-12, Geldbetrag.integerToGeldbetrag(Integer.valueOf(-1222)).euroAnteil());
        assertEquals(-22, Geldbetrag.integerToGeldbetrag(Integer.valueOf(-1222)).centAnteil());
    }
    
    @Test
    public void testeIntToGeldbetrag()
    {
        assertEquals(-12, Geldbetrag.intToGeldbetrag(-1222).euroAnteil());
        assertEquals(-22, Geldbetrag.intToGeldbetrag(-1222).centAnteil());
    }
    
    @Test
    public void testeToString()
    {
        Geldbetrag test = Geldbetrag.valueOf(15, 5);
        assertEquals("7,78€", d.toString());
        assertEquals("15,00€", a.toString());
        assertEquals("15,05€", test.toString());
    }
}
