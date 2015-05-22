package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.*;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;

public class VormerkkarteTest
{

    private Kunde _kunde1;
    private Kunde _kunde2;
    private Kunde _kunde3;
    private Vormerkkarte _karte;
    
    public VormerkkarteTest()
    {
        _kunde1 =  new Kunde(new Kundennummer(400223), "Marvin", "Robot");
        _kunde2 =  new Kunde(new Kundennummer(101234), "Hans", "Wurst");
        _kunde3 =  new Kunde(new Kundennummer(102030), "Sesselsesse", "Esteban");
        _karte = new Vormerkkarte();
    }
    
    @Test 
    public void testeFuegeHinzu()
    {
        assertFalse(_karte.istMediumVollgemerkt());
        assertFalse(_karte.istVormerkerInSchlange(_kunde1));
        _karte.fuegenVormerkerEin(_kunde1);
        assertTrue(_karte.istVormerkerInSchlange(_kunde1));
        assertTrue(_karte.istMediumVorgemerkt());
        
        _karte.fuegenVormerkerEin(_kunde2);
        _karte.fuegenVormerkerEin(_kunde3);
        assertTrue(_karte.istVormerkerInSchlange(_kunde2));
        assertTrue(_karte.istVormerkerInSchlange(_kunde3));
        
        assertTrue(_karte.istMediumVollgemerkt());
    }
    
    @Test
    public void testeEntfernen()
    {
        _karte.fuegenVormerkerEin(_kunde1);
        _karte.fuegenVormerkerEin(_kunde2);
        _karte.fuegenVormerkerEin(_kunde3);
        assertTrue(_karte.istMediumVollgemerkt());
        _karte.vormerkersNachVorneVerschiben();
        assertFalse(_karte.istMediumVollgemerkt());
        assertFalse(_karte.istVormerkerInSchlange(_kunde1));
    }
}
