package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlansicht;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class BezahlWerkzeugUI
{

    private JDialog _diaBezahlansicht;
    private JTextField _restbetragTxtField;
    private JTextField _gezahlterBetragTxtField;
    private JTextField _preisTxtField;
    private JTextField _wechselgeldTxtField;
    private JButton _okButton;
    private JButton _abbrechenButton;
    private JTextArea _ausgewaehltePlaetze;
    private JTextArea _ausgewaehlteVorstellung;

    /**
     * Create the application.
     */
    public BezahlWerkzeugUI()
    {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
        _diaBezahlansicht = new JDialog();
        _diaBezahlansicht.setResizable(false);
        _diaBezahlansicht.setTitle("Bezahlansicht");
        _diaBezahlansicht.setBounds(100, 100, 450, 300);
        _diaBezahlansicht.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        _diaBezahlansicht.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);
        
        _abbrechenButton = new JButton("Abbrechen");
        _abbrechenButton.setBounds(327, 228, 100, 23);
        panel.add(_abbrechenButton);
        
        _okButton = new JButton("OK");
        _okButton.setBounds(217, 228, 100, 23);
        panel.add(_okButton);
        _okButton.setEnabled(false);
        
        _restbetragTxtField = new JTextField();
        _restbetragTxtField.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        _restbetragTxtField.setEditable(false);
        _restbetragTxtField.setBounds(341, 160, 86, 20);
        panel.add(_restbetragTxtField);
        _restbetragTxtField.setColumns(10);
        
        _gezahlterBetragTxtField = new JTextField();
        _gezahlterBetragTxtField.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        _gezahlterBetragTxtField.setBounds(341, 130, 86, 20);
        panel.add(_gezahlterBetragTxtField);
        _gezahlterBetragTxtField.setColumns(10);
        
        _preisTxtField = new JTextField();
        _preisTxtField.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        _preisTxtField.setEditable(false);
        _preisTxtField.setBounds(341, 106, 86, 20);
        panel.add(_preisTxtField);
        _preisTxtField.setColumns(10);
        
        _wechselgeldTxtField = new JTextField();
        _wechselgeldTxtField.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        _wechselgeldTxtField.setEditable(false);
        _wechselgeldTxtField.setBounds(341, 184, 86, 20);
        panel.add(_wechselgeldTxtField);
        _wechselgeldTxtField.setColumns(10);
        
        JTextArea txtrZuZahlenderBetrag = new JTextArea();
        txtrZuZahlenderBetrag.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        txtrZuZahlenderBetrag.setEditable(false);
        txtrZuZahlenderBetrag.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
        txtrZuZahlenderBetrag.setText("Zu zahlender Betrag: *");
        txtrZuZahlenderBetrag.setBounds(181, 107, 136, 20);
        panel.add(txtrZuZahlenderBetrag);
        
        JTextArea txtrZuZahlenderBetrag_1 = new JTextArea();
        txtrZuZahlenderBetrag_1.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        txtrZuZahlenderBetrag_1.setEditable(false);
        txtrZuZahlenderBetrag_1.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
        txtrZuZahlenderBetrag_1.setText("Gezahlter Betrag: *");
        txtrZuZahlenderBetrag_1.setBounds(181, 131, 136, 20);
        panel.add(txtrZuZahlenderBetrag_1);
        
        JTextArea txtrRestbetrag = new JTextArea();
        txtrRestbetrag.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        txtrRestbetrag.setEditable(false);
        txtrRestbetrag.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
        txtrRestbetrag.setText("Restbetrag: *");
        txtrRestbetrag.setBounds(181, 161, 136, 20);
        panel.add(txtrRestbetrag);
        
        JTextArea txtrWechselgeld = new JTextArea();
        txtrWechselgeld.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        txtrWechselgeld.setBackground(UIManager.getColor("FormattedTextField.disabledBackground"));
        txtrWechselgeld.setEditable(false);
        txtrWechselgeld.setText("Wechselgeld: *");
        txtrWechselgeld.setBounds(181, 185, 136, 20);
        panel.add(txtrWechselgeld);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(181, 153, 246, 2);
        panel.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setOrientation(SwingConstants.VERTICAL);
        separator_1.setBounds(329, 106, 2, 99);
        panel.add(separator_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(20, 11, 406, 66);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        _ausgewaehlteVorstellung = new JTextArea();
        _ausgewaehlteVorstellung.setBackground(new Color(102, 204, 255));
        _ausgewaehlteVorstellung.setLineWrap(true);
        _ausgewaehlteVorstellung.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        _ausgewaehlteVorstellung.setEditable(false);
        _ausgewaehlteVorstellung.setBounds(0, 0, 406, 66);
        panel_1.add(_ausgewaehlteVorstellung);
        _ausgewaehlteVorstellung.setText("Ausgewählte Vorstellung:");
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(20, 88, 136, 148);
        panel.add(scrollPane);
        
        _ausgewaehltePlaetze = new JTextArea();
        _ausgewaehltePlaetze.setBackground(new Color(0, 204, 204));
        _ausgewaehltePlaetze.setFont(new Font("DINPro-Medium", Font.PLAIN, 13));
        _ausgewaehltePlaetze.setEditable(false);
        _ausgewaehltePlaetze.setText("Ausgewählte Plätze:");
        scrollPane.setViewportView(_ausgewaehltePlaetze);
        
        JTextPane txtpnalleBetrgeIn = new JTextPane();
        txtpnalleBetrgeIn.setFont(new Font("DINPro-Medium", Font.PLAIN, 12));
        txtpnalleBetrgeIn.setBackground(UIManager.getColor("FormattedTextField.inactiveBackground"));
        txtpnalleBetrgeIn.setEditable(false);
        txtpnalleBetrgeIn.setText("* in Eurocent");
        txtpnalleBetrgeIn.setBounds(20, 247, 86, 14);
        panel.add(txtpnalleBetrgeIn);
    }
    
    public void macheBezahlansichtSichtbar()
    {
        _diaBezahlansicht.setVisible(true);
    }
    
    public void setModal()
    {
        _diaBezahlansicht.setModal(true);
    }
    
    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
        _diaBezahlansicht.dispose();
    }
    
    public JButton getOKButton()
    {
        return _okButton;
    }
    
    public JButton getAbbrechenButton()
    {
        return _abbrechenButton;
    }
    
    public JTextField getRestbetragField()
    {
        return _restbetragTxtField;
    }
    
    public JTextField getGezahlterBetragField()
    {
        return _gezahlterBetragTxtField;
    }
    
    public JTextField getPreisField()
    {
        return _preisTxtField;
    }
    
    public JTextArea getAusgewaehltePlaetzeField()
    {
        return _ausgewaehltePlaetze;
    }
    
    public JTextArea getAusgewaehlteVorstellungField()
    {
        return _ausgewaehlteVorstellung;
    }
    
    private String getEingabeInsGezahlterBetragField()
    {
        String s = "";
        try
        {
            s = getGezahlterBetragField().getText();
        }
        catch(NullPointerException e)
        {
        }
        return s;
    }
    
    private int convertStringToInt(String eingabe)
    {
        int gezahlterBetrag = 0;
        try
        {
            gezahlterBetrag = Integer.parseInt(eingabe);
        }
        catch(NumberFormatException e)
        {
            JOptionPane warningPane = new JOptionPane();
            warningPane.setMessage("Es dürfen nur positive Zahlen eingegeben werden!");
            warningPane.setVisible(true);
        }
        return gezahlterBetrag;
    }
    
    public int getGezahltenBetrag()
    {
        return convertStringToInt(getEingabeInsGezahlterBetragField());
    }
    
    public void setGezahlterBetragField(String s)
    {
        _gezahlterBetragTxtField.setText(s);
    }
    
    public void setRestbetragField(String s)
    {
        _restbetragTxtField.setText(s);
    }
    
    public void setPreisField(String s)
    {
        _preisTxtField.setText(s);
    }
    
    public void setWechselgeldField(String s)
    {
        _wechselgeldTxtField.setText(s);
    }
    
    public void setAusgewaehltePlaetzeTxtField(String s)
    {
        _ausgewaehltePlaetze.setText("Ausgewählte Plätze:" + s);
    }
    
    public void setAusgewaehlteVorstellungField(String datum, String vorstellung)
    {
        _ausgewaehlteVorstellung.setText("Ausgewählte Vorstellung: " + datum + "\n" + "\n" + vorstellung);
    }
}
