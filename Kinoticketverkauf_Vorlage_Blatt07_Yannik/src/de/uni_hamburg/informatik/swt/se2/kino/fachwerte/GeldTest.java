package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GeldTest {
	@Test
	public void testeHashEquals(){
        Geld g1 = new Geld(7);
        Geld g2 = new Geld(7);
        Geld g3 = new Geld(70);
        Geld g4 = new Geld(07);

        assertTrue(g1.equals(g2));
        assertTrue(g1.hashCode() == g2.hashCode());

        assertFalse(g1.equals(g3));
        assertTrue(g1.equals(g4));

	}
	
	@Test
	public void testeToString() {
		Geld test = new Geld(0);
		assertEquals(test.toString(), "0.00 Euro");
		test = new Geld(9);
		assertEquals(test.toString(), "0.09 Euro");
		test = new Geld(10);
		assertEquals(test.toString(), "0.10 Euro");
		test = new Geld(99);
		assertEquals(test.toString(), "0.99 Euro");
		test = new Geld(100);
		assertEquals(test.toString(), "1.00 Euro");
		test = new Geld(12345);
		assertEquals(test.toString(), "123.45 Euro");

	}
}
