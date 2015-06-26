package se2.kino.werkzeuge.kasse;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Due UI-Klasse zu {@link BarzahlungsWerkzeug}
 * 
 * @author Niklas
 *
 */
public class BarzahlungsWerkzeugUI {
	private static final String TITEL = "Barzahlung";

	private JDialog _dialog;
	private JPanel _inputPanel;
	private JPanel _brechnungsPanel;
	private JPanel _preisPanel;
	private JPanel _buttonPanel;
	private JTextField _geldEingabe;
	private JLabel _preisLabel;
	private JLabel _rueckgeldLabel;
	private JButton _okButton;
	private JButton _abbrechenButton;

	public BarzahlungsWerkzeugUI() {
		// TODO: GUI-Elemente erzeugen.
		initFrame();
		initInputPanel();
		initCalculationPanel();
		initButtonPanel();
	}

	/**
	 * Initialisiert den HauptFrame des Fensters.
	 */
	private void initFrame() {
		// TODO: JFrame erzeugen.
		_dialog = new JDialog();
		_dialog.setTitle(TITEL);
		_dialog.setModal(true);
		_dialog.setLayout(new BoxLayout(_dialog.getContentPane(),
				BoxLayout.Y_AXIS));

		_dialog.setLocationRelativeTo(null);
		_dialog.setResizable(false);
		_dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	/**
	 * Initialisiert das Input Panel. Das Input Panel besteht aus einem Label,
	 * welches dem Benutzer zeigt, welcher Wert eingegeben werden soll und ein
	 * Textfeld für den Geldbetrag, der Bar gezahlt wurde.
	 */
	private void initInputPanel() {
		// TODO: input Panel erzeugen.
		JLabel label = new JLabel("Gegebenes Geld:");
		_geldEingabe = new JTextField(5);

		_inputPanel = new JPanel();

		_inputPanel.add(label);
		_inputPanel.add(_geldEingabe);

		_dialog.add(_inputPanel);
	}

	/**
	 * Initialisiert das Calculation Panel. In diesem befinden sich JLabel mit
	 * den Informationen über: den akutell eingezahlten Betrag, den zu zahlenden
	 * Betrag.
	 */
	private void initCalculationPanel() {
		// TODO: Calculation Panel erzeugen.
		JLabel rueckgeldBeschriftung = new JLabel("Rückgeld:");
		JLabel preisBeschriftung = new JLabel("Preis:");

		_preisLabel = new JLabel("0 Eurocent");
		_rueckgeldLabel = new JLabel("0 Eurocent");

		
		_brechnungsPanel = new JPanel();
		_preisPanel = new JPanel();

		_preisPanel.add(preisBeschriftung);
		_preisPanel.add(_preisLabel);
		_brechnungsPanel.add(rueckgeldBeschriftung);
		_brechnungsPanel.add(_rueckgeldLabel);

		_dialog.add(_preisPanel);
		_dialog.add(_brechnungsPanel);
	}

	/**
	 * Initialisiert das Button Panel. Hier gibt es zwei Buttons. Einen um die
	 * Barzahlung auszuführen (nur aktiv, wenn genügend Bargeld bezahlt wurde)
	 * und einen zum Abrrechen, falls sich ein Kinobesucher es anders überlegt.
	 */
	private void initButtonPanel() {
		// TODO: ButtonPanel erzeugen.
		_okButton = new JButton("OK");
		_okButton.setEnabled(false);
		_abbrechenButton = new JButton("Abbrechen");

		_buttonPanel = new JPanel();
		_buttonPanel.add(_okButton);
		_buttonPanel.add(_abbrechenButton);

		_dialog.add(_buttonPanel);
	}

	/**
	 * Zeigt das Fenster an, mit dem der Benutzer Barzahlungen vornehmen kann.
	 */
	public void zeigeFenster() {
		// TODO: Fenster anzeigen.
		aktualisiereGroesse();
		_dialog.setVisible(true);
	}

	/**
	 * Versteckt das Fenster.
	 */
	public void versteckeFenster() {
		_dialog.setVisible(false);
	}

	/**
	 * Passt die Größe des Dialoges der ELemente an.
	 */
	public void aktualisiereGroesse() {
		_dialog.pack();
	}

	/**
	 * Gibt das Geldeingabe Feld des Fensters zurück.
	 * 
	 * @return Das Geldeingabefeld.
	 */
	public JTextField getGeldEingabe() {
		return _geldEingabe;
	}

	/**
	 * Gibt das Label zurück, dass den Preis der Karten anzeigen soll.
	 * 
	 * @return das Preis JLabel.
	 */
	public JLabel getPreisAnzeige() {
		return _preisLabel;
	}

	/**
	 * Gibt das Label zurück, welches anzeigt wie viel Rückgeld der Kunde
	 * erhält.
	 * 
	 * @return das Rückgeld JLabel.
	 */
	public JLabel getRueckgeldAnzeige() {
		return _rueckgeldLabel;
	}

	/**
	 * Gibt den Button zurück, der den Vorgang beendet und die Karten verkauft.
	 * 
	 * @return der OK JButton.
	 */
	public JButton getOKButton() {
		return _okButton;
	}

	/**
	 * Gibt den Button zurück, der den Vorgang abbricht und die Plätze nicht
	 * verkauft.
	 * 
	 * @return der Abrrechen JButton.
	 */
	public JButton getAbbrechenButton() {
		return _abbrechenButton;
	}

}