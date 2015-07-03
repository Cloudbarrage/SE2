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
        _cent = eurocent % 100;
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

    public static Geldbetrag valueOf(String s)
    {
        Matcher matcher = regex.matcher(s);
        if(matcher.matches())
        {
            String euro = matcher.group(1);
            String cent = matcher.group(2);
            return new Geldbetrag(Integer.valueOf(euro), Integer.valueOf(cent));
        }
        return null;
    }
    
    private static final Pattern regex = Pattern.compile("(-?\\d+),?(-?\\d*)€?");
    
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
        if(_cent < 10 && _cent > -10)
        {
            return _euro + ",0" + _cent + "€";
        }
        return _euro + "," + _cent + "€";
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Geldbetrag)
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
        return ((this.centAnteil() + this.euroAnteil()*100) >= (g.centAnteil() + g.euroAnteil()*100));
    }
}
