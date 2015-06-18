package de.uni_hamburg.informatik.swt.se2.kino.bezahl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

public class BezahlWerkzeug extends ObservableSubwerkzeug
{
    private BezahlWerkzeugUI _ui;
    private int _preis;
    
    public BezahlWerkzeug(int preis)
    {
        _preis = preis;
        _ui = new BezahlWerkzeugUI(_preis);
    }
    
    public void setUndzeigFenster()
    {
        registriereUIAktionen();
        _ui.zeigeFentser();
    }

    private void registriereUIAktionen()
    {
        _ui.getCancelButton().addActionListener(new ActionListener()
        {
            @Override 
            public void actionPerformed(ActionEvent e)
            {
                _ui.schliessenFenster();
            }
        });
        _ui.getOKButton().addActionListener(new ActionListener()
        {
            @Override 
            public void actionPerformed(ActionEvent e)
            {
                _ui.schliessenFenster();
                informiereUeberAenderung();
            }
        });
        _ui.getBezahltGeld().getDocument().addDocumentListener(new DocumentListener()
        {

            @Override
            public void insertUpdate(DocumentEvent e)
            {
                String text = _ui.getBezahltGeld().getText();
                berechnenBezahltGeld(text);            
            }

            @Override
            public void removeUpdate(DocumentEvent e)
            {
                String text = _ui.getBezahltGeld().getText();
                berechnenBezahltGeld(text);           
            }

            @Override
            public void changedUpdate(DocumentEvent e)
            {
                String text = _ui.getBezahltGeld().getText();
                berechnenBezahltGeld(text);
            }
        });
    }
    
    public void berechnenBezahltGeld(String text)
    {
        if(!text.isEmpty())
        {
            if(text.matches("[0-9]*"))
            {
                int betragzahl = Integer.parseInt(text);
                if (betragzahl >= _preis)
                {
                    Integer geld = betragzahl - _preis;
                    String restgeld = geld.toString();
                    _ui.getRestGeld().setText(restgeld);
                    _ui.getOKButton().setEnabled(true);
                }
                else if(betragzahl < _preis)
                {
                    String restgeld = ("-" + (_preis - betragzahl));
                    _ui.getRestGeld().setText(restgeld);
                    _ui.getOKButton().setEnabled(false);
                }
            }
            else
            {
                _ui.getRestGeld().setText("ungiltig wert");
                _ui.getOKButton().setEnabled(false);
            }
        }
    }
}
