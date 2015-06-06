package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.math.*;

public class Geld {
	private final BigDecimal _eurocent;

	public Geld(int betrag) {
		_eurocent = BigDecimal.valueOf(betrag);
	}

	public Geld(BigDecimal betrag) {
		_eurocent = betrag;
	}

	public Geld multiply(int multi) {
		return new Geld(_eurocent.multiply(BigDecimal.valueOf(multi)));
	}

	public Geld add(Geld geld) {
		return new Geld(_eurocent.add(geld.decValue()));
	}
	
	public Geld substract(Geld geld) {
		return new Geld(_eurocent.subtract(geld.decValue()));
	}

	public String toString() {
		String string = _eurocent.toString();
		while (string.length() < 3) {
			string = "0" + string;
		}
		string = new StringBuilder(string).insert(string.length() - 2, ".")
				.toString() + " Euro";
		return string;
	}

	public BigDecimal decValue() {
		return _eurocent;
	}
	
	public int hashCode(){
		return _eurocent.hashCode();
	}
	
	public boolean equals(Object o){
		boolean ergebnis = false;
        if (o instanceof Geld)
        {
            Geld geld = (Geld) o;
            ergebnis = _eurocent.equals(geld.decValue());
        }
        return ergebnis;
	}
}
