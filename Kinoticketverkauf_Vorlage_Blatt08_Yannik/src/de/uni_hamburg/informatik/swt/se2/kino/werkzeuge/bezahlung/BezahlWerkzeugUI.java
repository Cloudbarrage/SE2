package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;
import java.awt.SystemColor;

public class BezahlWerkzeugUI
{
    //TODO Grafik verbessern
    private JFrame _frame;
    private JTextField _textField;
    private JButton _ok;
    private JButton _abbrechen;
    private JTextPane _zuZahlenderPreis;
    private JTextPane _rueckzugebenderPreis;

    public BezahlWerkzeugUI(Geld preis)
    {
        _frame = new JFrame("Bezahlung");
        _frame.setResizable(false);
        _frame.setAlwaysOnTop(true);
        _frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        SpringLayout springLayout = new SpringLayout();
        _frame.getContentPane()
            .setLayout(springLayout);

        _abbrechen = new JButton("Abbrechen");
        _frame.getContentPane()
            .add(_abbrechen);

        _ok = new JButton("OK");
        springLayout.putConstraint(SpringLayout.NORTH, _abbrechen, 0,
                SpringLayout.NORTH, _ok);
        springLayout.putConstraint(SpringLayout.WEST, _abbrechen, 6,
                SpringLayout.EAST, _ok);
        _ok.setEnabled(false);
        _frame.getContentPane()
            .add(_ok);

        _textField = new JTextField();
        springLayout.putConstraint(SpringLayout.WEST, _textField, 20,
                SpringLayout.WEST, _frame.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, _ok, 0,
                SpringLayout.WEST, _textField);
        _frame.getContentPane()
            .add(_textField);
        _textField.setColumns(25);

        _zuZahlenderPreis = new JTextPane();
        _zuZahlenderPreis.setBackground(SystemColor.window);
        springLayout.putConstraint(SpringLayout.EAST, _textField, -10,
                SpringLayout.EAST, _zuZahlenderPreis);
        springLayout.putConstraint(SpringLayout.NORTH, _zuZahlenderPreis, 10,
                SpringLayout.NORTH, _frame.getContentPane());
        springLayout.putConstraint(SpringLayout.WEST, _zuZahlenderPreis, 10,
                SpringLayout.WEST, _frame.getContentPane());
        _zuZahlenderPreis.setText("Zu bezahlen: " + preis);
        _frame.getContentPane()
            .add(_zuZahlenderPreis);

        _rueckzugebenderPreis = new JTextPane();
        _rueckzugebenderPreis.setBackground(SystemColor.window);
        springLayout.putConstraint(SpringLayout.NORTH, _ok, 10,
                SpringLayout.SOUTH, _rueckzugebenderPreis);
        springLayout.putConstraint(SpringLayout.NORTH, _rueckzugebenderPreis,
                66, SpringLayout.NORTH, _frame.getContentPane());
        springLayout.putConstraint(SpringLayout.SOUTH, _textField, -6,
                SpringLayout.NORTH, _rueckzugebenderPreis);
        springLayout.putConstraint(SpringLayout.WEST, _rueckzugebenderPreis, 0,
                SpringLayout.WEST, _zuZahlenderPreis);
        _rueckzugebenderPreis.setText("Betrag nicht ausreichen");
        _frame.getContentPane()
            .add(_rueckzugebenderPreis);
    }

    public void setRueckzugebenderPreis(Geld preis)
    {
        if (preis.signum() != -1)
        {
            _rueckzugebenderPreis.setText("Rueckgabe: " + preis);
        }
        else
        {
            _rueckzugebenderPreis.setText("Betrag nicht ausreichen");
        }
    }

    public JFrame getFrame()
    {
        return _frame;
    }

    public JTextField getTextField()
    {
        return _textField;
    }

    public JButton getOKButton()
    {
        return _ok;
    }

    public JButton getAbbrechenButton()
    {
        return _abbrechen;
    }

    public void close()
    {
        _frame.dispose();
    }

    public void zeigeFenster()
    {
        _frame.setSize(250, 150);
        _frame.setLocation(450, 300);
        _frame.setVisible(true);
    }
}
