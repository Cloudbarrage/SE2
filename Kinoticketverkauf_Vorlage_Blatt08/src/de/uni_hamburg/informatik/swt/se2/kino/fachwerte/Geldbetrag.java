/**
 * 
 */
package de.uni_hamburg.informatik.swt.se2.kino.fachwerte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Leroy
 *
 */
public class Geldbetrag
{
    private final int _euro;
    private final int _cent;

    private Geldbetrag(int euro, int cent)
    {
        int eurocent = euro * 100 + cent;
        _euro = eurocent / 100;
        _cent = (eurocent % 100);
    }

    public int euroAnteil()
    {
        return _euro;
    }

    public int centAnteil()
    {
        return _cent;
    }

    public static Geldbetrag valueOf(int euro, int cent)
    {
        return new Geldbetrag(euro, cent);
    }

    public static Geldbetrag valueOf(String s) throws NumberFormatException, IllegalStateException
    {
        Matcher matcher = regex.matcher(s);
        if (matcher.matches())
        {
            String vorzeichen = matcher.group(1);
            String euro = matcher.group(2);
            String cent = matcher.group(3);
            int eur = 0;
            int cen = 0;
            eur = Integer.valueOf(euro);
            cen = Integer.valueOf(cent);
            if (vorzeichen.equals("-"))
            {
                eur = eur * (-1);
                cen = cen * (-1);
            }
            if (cent.length() == 1)
            {
                cen = cen * 10;
            }
            return new Geldbetrag(eur, cen);
        }
        throw new IllegalStateException();
    }

    private static final Pattern regex = Pattern.compile("(-?)(\\d+),?(\\d*)€?");

    public static Geldbetrag valueOf(Integer i)
    {
        int eurocent = i.intValue();
        return new Geldbetrag(eurocent / 100, eurocent % 100);
    }

    public static Geldbetrag valueOf(int i)
    {
        return new Geldbetrag(i / 100, i % 100);
    }

    public Geldbetrag berechneSummeMit(Geldbetrag a)
    {
        int centSumme = a.centAnteil() + this.centAnteil();
        int euroSumme = a.euroAnteil() + this.euroAnteil();
        return new Geldbetrag(euroSumme, centSumme);
    }

    public Geldbetrag subtrahiere(Geldbetrag a)
    {
        int centDiff = this.centAnteil() - a.centAnteil();
        int euroDiff = this.euroAnteil() - a.euroAnteil();
        return new Geldbetrag(euroDiff, centDiff);
    }

    public Geldbetrag multipliziereMit(int faktor)
    {
        int cent = this.centAnteil() * faktor;
        int euro = this.euroAnteil() * faktor;
        return new Geldbetrag(euro, cent);
    }

    @Override
    public String toString()
    {
        String s = "";
        if (_cent < 10 && _cent > -10)
        {
            if (_cent < 0)
            {
                if (_euro == 0)
                {
                    s = "-" + _euro + ",0" + ((-1) * _cent) + "€";
                }
                if (_euro < 0)
                {
                    s = _euro + ",0" + ((-1) * _cent) + "€";
                }
            }
            else
            {
                s = _euro + ",0" + _cent + "€";
            }
        }
        else
        {
            if (_cent < 0)
            {
                if (_euro == 0)
                {
                    s = "-" + _euro + "," + ((-1) * _cent) + "€";
                }
                if (_euro < 0)
                {
                    s = _euro + "," + ((-1) * _cent) + "€";
                }
            }
            else
            {
                s = _euro + "," + _cent + "€";
            }
        }
        return s;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Geldbetrag)
        {
            Geldbetrag a = (Geldbetrag) o;
            return (_euro == a.euroAnteil() && _cent == a.centAnteil());
        }
        return false;
    }

    @Override
    public int hashCode()
    {
        return (_euro + _cent) * 42;
    }

    public boolean grösserGleich(Geldbetrag g)
    {
        return ((this.centAnteil() + this.euroAnteil() * 100) >= (g.centAnteil() + g.euroAnteil() * 100));
    }
}
