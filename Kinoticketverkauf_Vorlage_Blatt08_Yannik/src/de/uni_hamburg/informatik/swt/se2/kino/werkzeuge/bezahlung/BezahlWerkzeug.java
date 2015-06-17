package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;

public class BezahlWerkzeug extends Observable
{
    private BezahlWerkzeugUI _ui;

    private Geld zuBezahlenderPreis;

    public BezahlWerkzeug(Geld preis)
    {
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
                    bezahlt();
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
            .getDocument()
            .addDocumentListener(new DocumentListener()
            {
                @Override
                public void insertUpdate(DocumentEvent e)
                {
                    textfieldUpdate();
                }

                @Override
                public void removeUpdate(DocumentEvent e)
                {
                    textfieldUpdate();
                }

                @Override
                public void changedUpdate(DocumentEvent e)
                {
                    textfieldUpdate();
                }
            });
    }

    private void textfieldUpdate()
    {
        if (_ui.getTextField()
            .getText()
            .matches("[0-9]*"))
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
        else{
            _ui.setRueckzugebenderPreis(new Geld(-1));
        }
    }

    private Geld bezahlterPreis()
    {
        return new Geld(Long.parseLong(_ui.getTextField()
            .getText()));
    }

    private Geld berechneRückgabewert()
    {
        return bezahlterPreis().substract(zuBezahlenderPreis);
    }

    private void bezahlt()
    {
        setChanged();
        notifyObservers();
    }

}
