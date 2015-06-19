package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;

public class BezahlWerkzeug extends Observable
{
    private enum bezahlZustand
    {
        FALSCHE_EINGABE, NICHT_AUSREICHEND, AUSREICHEND
    }

    private BezahlWerkzeugUI _ui;

    private Geld zuBezahlenderPreis;

    public BezahlWerkzeug(Geld preis)
    {
        zuBezahlenderPreis = preis;
    }

    private void registriereUIAktionen()
    {
        _ui.getOKButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    _ui.close();
                    bezahlt();
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
                    if (rueckgabeMoeglich() == bezahlZustand.AUSREICHEND)
                    {
                        _ui.close();
                        bezahlt();
                    }
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
        switch (rueckgabeMoeglich())
        {
        case AUSREICHEND:
            _ui.getOKButton()
                .setEnabled(true);
            break;
        case NICHT_AUSREICHEND:
            _ui.getOKButton()
                .setEnabled(false);
            break;
        case FALSCHE_EINGABE:
            setRueckzugebenderPreis(false);
            break;

        default:
            break;
        }
    }
    
    public void setRueckzugebenderPreis(Geld preis)
    {
        if (preis.signum() != -1)
        {
            _ui.getRueckzugebenderPreis().setText("Rueckgabe: " + preis);
        }
        else
        {
            setRueckzugebenderPreis(false);
        }
    }

    public void setRueckzugebenderPreis(boolean beFalse)
    {
        if (!beFalse)
        {
            _ui.getRueckzugebenderPreis().setText("Betrag nicht ausreichend");
        }
    }

    private bezahlZustand rueckgabeMoeglich()
    {
        if (!_ui.getTextField()
            .getText()
            .matches("[0-9]*") || _ui.getTextField()
            .getText()
            .length() == 0)
        {
            return bezahlZustand.FALSCHE_EINGABE;
        }

        Geld rueckgabe = berechneRückgabewert();
        setRueckzugebenderPreis(rueckgabe);
        if (rueckgabe.signum() != -1)
        {
            return bezahlZustand.AUSREICHEND;
        }
        else
        {
            return bezahlZustand.NICHT_AUSREICHEND;
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

    public void startUI()
    {
        _ui = new BezahlWerkzeugUI(zuBezahlenderPreis);
        registriereUIAktionen();
        _ui.zeigeFenster();
    }
}
