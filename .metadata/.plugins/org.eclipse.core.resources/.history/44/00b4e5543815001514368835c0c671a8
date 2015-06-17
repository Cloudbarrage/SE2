package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.math.*;

/**
 * Geldbetrag in Eurocent, gespeichert mit dem genauen Datentyp BigDecimal
 */
public final class Geld
{
    private final BigDecimal _eurocent;

    public Geld(int betrag)
    {
        _eurocent = BigDecimal.valueOf(betrag);
    }

    public Geld(BigDecimal betrag)
    {
        _eurocent = betrag;
    }

    public Geld multiply(int multi)
    {
        return new Geld(_eurocent.multiply(BigDecimal.valueOf(multi)));
    }

    public Geld add(Geld geld)
    {
        return new Geld(_eurocent.add(geld.decValue()));
    }

    public Geld substract(Geld geld)
    {
        return new Geld(_eurocent.subtract(geld.decValue()));
    }

    public String toString()
    {
        BigDecimal eurocent = _eurocent;
        Boolean negative = false;
        if (_eurocent.signum() == -1)
        {
            eurocent = _eurocent.abs();
            negative = true;
        }
        String string = eurocent.toString();
        while (string.length() < 3)
        {
            string = "0" + string;
        }
        string = new StringBuilder(string).insert(string.length() - 2, ",")
            .toString() + " Euro";
        if (negative)
        {
            string = new StringBuilder(string).insert(0, "-")
                .toString();
        }
        return string;
    }

    /**
     * 
     * @return eurocent als BigDecimal
     */
    public BigDecimal decValue()
    {
        return _eurocent;
    }

    /**
     * Geld ist nur über seinen eurocent Wert definiert.
     */
    public int hashCode()
    {
        return _eurocent.hashCode();
    }

    /**
     * Zwei Geldbeträge sind gleich, wenn ihr eurocent Wert gleich ist.
     */
    public boolean equals(Object o)
    {
        boolean ergebnis = false;
        if (o instanceof Geld)
        {
            Geld geld = (Geld) o;
            ergebnis = _eurocent.equals(geld.decValue());
        }
        return ergebnis;
    }
    
    public Geld abs(){
        return new Geld(_eurocent.abs());
    }
    
    public int signum(){
        return _eurocent.signum();
    }
}
