package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlansicht;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Platz;
import de.uni_hamburg.informatik.swt.se2.kino.materialien.Vorstellung;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

public class BezahlWerkzeug extends ObservableSubwerkzeug
{
    private Vorstellung _vorstellung;
    private int _gezahlterBetrag;
    private final int _preis;
    private final Set<Platz> _ausgewaehltePlaetze;
    private BezahlWerkzeugUI _ui;

    /**
     * Initialisiert das PlatzVerkaufsWerkzeug.
     */
    public BezahlWerkzeug(Vorstellung vorstellung, Set<Platz> plaetze)
    {
        _vorstellung = vorstellung;
        _gezahlterBetrag = 0;
        _preis = vorstellung.getPreisFuerPlaetze(plaetze);
        _ausgewaehltePlaetze = plaetze;
        _ui = new BezahlWerkzeugUI();
        
        _ui.setPreisField(toString(_preis));
        _ui.setAusgewaehltePlaetzeTxtField(ausgewaehltePlaetze());
        _ui.setAusgewaehlteVorstellungField(_vorstellung.getDatum().getFormatiertenString(), ausgewaehlteVorstellung());
        aktualisiereBezahlanzeige();
        registriereUIAktionen();
        _ui.setModal();
    }

    public void registriereUIAktionen()
    {
        _ui.getAbbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.schliesseFenster();
                }
            });

        _ui.getOKButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    informiereUeberAenderung();
                    _ui.schliesseFenster();
                }
            });

        _ui.getGezahlterBetragField()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _gezahlterBetrag = _ui.getGezahltenBetrag();
                    if (gezahlterBetragAusreichend())
                    {
                        _ui.getOKButton()
                            .setEnabled(true);
                    }
                    else
                    {
                        _ui.getOKButton().setEnabled(false);
                    }
                    aktualisiereBezahlanzeige();
                }
            });
    }

    public int getGezahltenBetrag()
    {
        return _ui.getGezahltenBetrag();
    }

    /**
     * @return Derjenige Geldbetrag, der noch gezahlt werden muss. 
     */
    public int getRestbetrag()
    {
        int restbetrag = _preis - _gezahlterBetrag;
        if (restbetrag < 0)
        {
            restbetrag = 0;
        }
        return restbetrag;
    }

    /**
     * @return Derjenige Geldbetrag, der vom Kassierer zurueckgegeben werden muss. 
     */
    public int getWechselgeld()
    {
        int wechselgeld = (-1) * (_preis - _gezahlterBetrag);
        if (wechselgeld < 0)
        {
            wechselgeld = 0;
        }
        return wechselgeld;
    }

    public String toString(int x)
    {
        return Integer.toString(x);
    }

    public boolean gezahlterBetragAusreichend()
    {
        return (_gezahlterBetrag >= _preis);
    }

    public void aktualisiereBezahlanzeige()
    {
        _ui.setGezahlterBetragField(toString(_gezahlterBetrag));
        _ui.setRestbetragField(toString(getRestbetrag()));
        _ui.setWechselgeldField(toString(getWechselgeld()));
    }
    
    public String ausgewaehltePlaetze()
    {
        String plaetze = "\n";
        for(Platz platz : _ausgewaehltePlaetze)
        {
            plaetze += "\n" + platz.toString();
        }
        return plaetze;
    }
    
    public String ausgewaehlteVorstellung()
    {
        return _vorstellung.toString();
    }

    public BezahlWerkzeugUI getBezahlWerkzeugUI()
    {
        return _ui;
    }
}
