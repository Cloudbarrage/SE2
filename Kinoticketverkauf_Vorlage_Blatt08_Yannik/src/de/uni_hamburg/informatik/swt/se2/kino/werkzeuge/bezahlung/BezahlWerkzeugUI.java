package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import de.uni_hamburg.informatik.swt.se2.kino.fachwerte.Geld;

import java.awt.SystemColor;
import java.awt.BorderLayout;

import javax.swing.Box;

public class BezahlWerkzeugUI
{
    private JFrame _frame;
    private JTextField _textField;
    private JButton _ok;
    private JButton _abbrechen;
    private JTextPane _zuZahlenderPreis;
    private JTextPane _rueckzugebenderPreis;
    private Box verticalBox;
    private Box horizontalBox;
    private Box verticalBox_1;

    public BezahlWerkzeugUI(Geld preis)
    {
        _frame = new JFrame("Bezahlung");
        _frame.setResizable(false);
        _frame.setAlwaysOnTop(true);
        _frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        _frame.getContentPane()
            .setLayout(new BorderLayout(0, 0));

        verticalBox_1 = Box.createVerticalBox();
        _frame.getContentPane()
            .add(verticalBox_1, BorderLayout.NORTH);

        verticalBox = Box.createVerticalBox();
        verticalBox_1.add(verticalBox);

        _zuZahlenderPreis = new JTextPane();
        _zuZahlenderPreis.setEditable(false);
        verticalBox.add(_zuZahlenderPreis);
        _zuZahlenderPreis.setBackground(SystemColor.window);
        _zuZahlenderPreis.setText("Zu bezahlen: " + preis);

        _textField = new JTextField();
        verticalBox.add(_textField);
        _textField.setColumns(10);

        _rueckzugebenderPreis = new JTextPane();
        _rueckzugebenderPreis.setEditable(false);
        verticalBox.add(_rueckzugebenderPreis);
        _rueckzugebenderPreis.setBackground(SystemColor.window);
        _rueckzugebenderPreis.setText("Betrag nicht ausreichend");

        horizontalBox = Box.createHorizontalBox();
        verticalBox_1.add(horizontalBox);

        _ok = new JButton("OK");
        horizontalBox.add(_ok);
        _ok.setEnabled(false);

        _abbrechen = new JButton("Abbrechen");
        horizontalBox.add(_abbrechen);
    }

    public void setRueckzugebenderPreis(Geld preis)
    {
        if (preis.signum() != -1)
        {
            _rueckzugebenderPreis.setText("Rueckgabe: " + preis);
        }
        else
        {
            _rueckzugebenderPreis.setText("Betrag nicht ausreichend");
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
        _frame.setSize(200, 120);
        _frame.setLocationRelativeTo(null);
        _frame.setVisible(true);
        _textField.requestFocusInWindow();
    }
}
