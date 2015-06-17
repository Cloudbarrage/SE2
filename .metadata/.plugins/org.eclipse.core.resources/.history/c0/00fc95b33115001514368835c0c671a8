package de.uni_hamburg.informatik.swt.se2.kino.bezahl;


import java.awt.*;
import javax.swing.*;

public class BezahlWerkzeugUI
{
    private JDialog _dialog; //hauptfenster borderlayout
    
    private JButton _okButton;
    private JButton _cancelButton; //in ein 1*2gridlayout, south
    
    private JLabel _zuZahlenLabel;
    private JLabel _zuZahlenBetrag;

    private JLabel _gegebenLabel; 
    private JTextField _gegebenBetrag;

    private JLabel _restLabel;
    private JLabel _restBetrag; // diesen drei in ein 3*2gridlayout, north

    private int _gesamtpreis;
    
    
    public BezahlWerkzeugUI(int preis)
    {
        assert preis > 0 : "Vorbedingung verletzt: preis >= 0";
        
        _gesamtpreis = preis;
        erstelleDialog(_gesamtpreis);      
    }

    public void erstelleDialog(int preis)
    {
        
        _dialog = new JDialog(new JDialog(), 
                "Barzahlung bestaetigen (in Eurocent)", true);
        _dialog.setSize(400,200);
        _dialog.setLocationRelativeTo(null);// fenster in center
        Container contentPane = _dialog.getContentPane();
        contentPane.setLayout(new BorderLayout());  //set hauptfenster und layout finished  

        _zuZahlenLabel = new JLabel("Gesamtpreis:");
        _zuZahlenBetrag = new JLabel(Integer.toString(preis));

        _gegebenLabel = new JLabel("GEGEBEN:");
        _gegebenBetrag = new JTextField(10);

        _restLabel = new JLabel("RÜCKGABE:");
        _restBetrag = new JLabel("-" + Integer.toString(preis));//set Label

        _okButton = new JButton("OK");
        _cancelButton = new JButton("Abbrechen");//set Button
        

        JPanel labelPanel = new JPanel();
        contentPane.add(labelPanel, BorderLayout.NORTH);
        GridLayout gridlayout = new GridLayout(3, 2);
        labelPanel.setLayout(gridlayout);// set labellayout
        
        gridlayout.addLayoutComponent(null, _zuZahlenLabel);
        gridlayout.addLayoutComponent(null, _zuZahlenBetrag);
             
        gridlayout.addLayoutComponent(null, _gegebenLabel);
        gridlayout.addLayoutComponent(null, _gegebenBetrag);

        gridlayout.addLayoutComponent(null, _restLabel);
        gridlayout.addLayoutComponent(null, _restBetrag);

        
        
        labelPanel.add(_zuZahlenLabel);
        labelPanel.add(_zuZahlenBetrag);

        labelPanel.add(_gegebenLabel);
        labelPanel.add(_gegebenBetrag);

        labelPanel.add(_restLabel);
        labelPanel.add(_restBetrag); //add element 



        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));

        _okButton.setEnabled(false);// bevor geld gegeben

        buttonPanel.add(_okButton);
        buttonPanel.add(_cancelButton);//set button panel

        contentPane.add(buttonPanel, BorderLayout.SOUTH);//add 
    }
        
        
    
    
    public JButton getOKButton()
    {
        return _okButton;
    }

    public JButton getCancelButton()
    {
        return _cancelButton;
    }

    
    // folgend 4 werden in werkzeug benutzt 
    public JTextField getBezahltGeld()
    {
        return _gegebenBetrag;
    }

    public JLabel getRestGeld()
    {
        return _restBetrag;
    }
    
    public void schliessenFenster()
    {
        _dialog.dispose();
    }
    
    public void zeigeFentser()
    {
        _dialog.setVisible(true);
    }
}
