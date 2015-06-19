package se2.kino.werkzeuge.kasse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarzahlungsWerkzeug implements ActionListener {

	private BarzahlungsWerkzeugUI _ui;
	private int _preis;

	public BarzahlungsWerkzeug(int preis) {
		_preis = preis;
		
		_ui = new BarzahlungsWerkzeugUI();

		registriereListener();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO ActionEventsreaktionen Programieren.

	}

	/**
	 * Aktualisiert die Anzeige. Das bedeutet der OK Button wird aktiv oder
	 * inaktiv und das Rückgeld wird berechnet.
	 */
	private void aktualisiereAnzeige() {
		_ui.getRueckgeldAnzeige().setText((berechneRueckgeld() / 100) + " Euro");
	}
	
	/**
	 * Berechnet das aktuell zu zahlende Rückgeld.
	 * @return das Rückgeld.
	 */
	private int berechneRueckgeld(){
		return _preis - getGeldeingabeInCent();
	}
	
	/**
	 * Gibt die eingegebene Geldsumme in Cent zurück.
	 * @return
	 */
	private int getGeldeingabeInCent(){
		String eingabeString = _ui.getGeldEingabe().getText();
		
		return (int) (Float.parseFloat(eingabeString) * 100);
	}

	/**
	 * Registriert alle notwendigen Listener.
	 */
	private void registriereListener() {
		_ui.getOKButton().addActionListener(this);
		_ui.getAbbrechenButton().addActionListener(this);
		_ui.getGeldEingabe().addActionListener(this);
	}
}
