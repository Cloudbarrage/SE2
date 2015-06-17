package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;
import de.uni_hamburg.informatik.swt.se2.kino.materialien.Vorstellung;
import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.platzverkauf.PlatzVerkaufsWerkzeug;

public class BezahlWerkzeug
{
    private BezahlWerkzeugUI _ui;

    private Geld zuBezahlenderPreis;
    private PlatzVerkaufsWerkzeug _platzVerkaufsWerkzeug;
    private Vorstellung _vorstellung;

    public BezahlWerkzeug(Geld preis,
            PlatzVerkaufsWerkzeug platzVerkaufsWerkzeug, Vorstellung vorstellung)
    {
        _vorstellung = vorstellung;
        _platzVerkaufsWerkzeug = platzVerkaufsWerkzeug;
        zuBezahlenderPreis = preis;
        _ui = new BezahlWerkzeugUI(zuBezahlenderPreis);
        registriereUIAktionen();
        _ui.zeigeFenster();
    }

    private void registriereUIAktionen()
    {
        _ui.getOKButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _platzVerkaufsWerkzeug.verkaufePlaetze(_vorstellung);
                    _ui.close();
                }
            });
        _ui.getAbbrechenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.close();
                }
            });
        _ui.getTextField()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    Geld rueckgabe = berechneRückgabewert();
                    _ui.setRueckzugebenderPreis(rueckgabe);
                    if (rueckgabe.signum() != -1)
                    {
                        _ui.getOKButton()
                            .setEnabled(true);
                    }
                    else
                    {
                        _ui.getOKButton()
                            .setEnabled(false);
                    }
                }
            });
    }

    private Geld bezahlterPreis()
    {
        return new Geld(Integer.parseInt(_ui.getTextField()
            .getText()));
    }

    private Geld berechneRückgabewert()
    {
        return bezahlterPreis().substract(zuBezahlenderPreis);
    }

}
