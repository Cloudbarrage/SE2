package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;


public class VormerkKarteTest
{
    private Medium _medium;
    private Kunde _kunde1;
    private Kunde _kunde2;
    private Kunde _kunde3;
    
    public VormerkKarteTest()
    {
        _medium = new CD("bar", "baz", "foo", 123);
        _kunde1 = new Kunde(new Kundennummer(123456), "Robin", "Hood");
        _kunde2 = new Kunde(new Kundennummer(121212), "Ein", "Stein");
        _kunde3 = new Kunde(new Kundennummer(235677), "Schroedingers", "Katze");
    }
    
    @Test
    public void testeIstErsterVormerker()
    {
        VormerkKarte karte = new VormerkKarte(_medium);
        karte.fuegeKundeHinzu(_kunde1);
        karte.fuegeKundeHinzu(_kunde2);
        karte.fuegeKundeHinzu(_kunde3);
        assertTrue(karte.istErsterVormerker(_kunde1));
        assertFalse(karte.istErsterVormerker(_kunde2));
        assertFalse(karte.istErsterVormerker(_kunde3));
    }
    
    @Test
    public void testeIstMaximaleAnzahlVormerkerErreicht()
    {
        VormerkKarte karte = new VormerkKarte(_medium);
        assertFalse(karte.istMaximaleAnzahlVormerkerErreicht());
        karte.fuegeKundeHinzu(_kunde1);
        assertFalse(karte.istMaximaleAnzahlVormerkerErreicht());
        karte.fuegeKundeHinzu(_kunde2);
        assertFalse(karte.istMaximaleAnzahlVormerkerErreicht());
        karte.fuegeKundeHinzu(_kunde3);
        assertTrue(karte.istMaximaleAnzahlVormerkerErreicht());
    }
    
    @Test
    public void testeHatKundeSchonVorgemerkt()
    {
        VormerkKarte karte = new VormerkKarte(_medium);
        karte.fuegeKundeHinzu(_kunde1);
        karte.fuegeKundeHinzu(_kunde2);
        assertTrue(karte.hatKundeSchonVorgemerkt(_kunde1));
        assertTrue(karte.hatKundeSchonVorgemerkt(_kunde2));
        assertFalse(karte.hatKundeSchonVorgemerkt(_kunde3));
    }
    
    @Test
    public void testeFuegeKundeHinzu()
    {
        VormerkKarte karte = new VormerkKarte(_medium);
        karte.fuegeKundeHinzu(_kunde1);
        assertEquals(karte.getAnzahlVormerkungen(), 1);
        karte.fuegeKundeHinzu(_kunde2);
        karte.fuegeKundeHinzu(_kunde2);
        assertEquals(karte.getAnzahlVormerkungen(), 3);
    }
}
