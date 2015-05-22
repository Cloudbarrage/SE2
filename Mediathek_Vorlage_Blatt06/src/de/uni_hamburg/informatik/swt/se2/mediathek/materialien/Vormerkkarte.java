package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

/**
 * Mit Hilfe von Verleihkarten werden beim Verleih eines Mediums alle relevanten
 * Daten notiert.
 * 
 * Sie beantwortet die folgenden Fragen: Welches Medium wurde ausgeliehen? Wer
 * hat das Medium ausgeliehen? Wann wurde das Medium ausgeliehen?
 * 
 * Wenn Medien zurück gegeben werden, kann die zugehörige Verleihkarte entsorgt
 * werden. Um die Verwaltung der Karten kümmert sich der VerleihService
 * 
 * @author SE2-Team
 * @version SoSe 2015
 */
public class Vormerkkarte {

	private List<Kunde> _vormerker;
	private final Medium _medium;

	/**
	 * Initialisert eine neue Verleihkarte mit den gegebenen Daten.
	 * 
	 * @param entleiher
	 *            Ein Kunde, der das Medium ausgeliehen hat.
	 * @param medium
	 *            Ein verliehene Medium.
	 * @param ausleihdatum
	 *            Ein Datum, an dem der Kunde das Medium ausgeliehen hat.
	 * 
	 * @require entleiher != null
	 * @require medium != null
	 * @require ausleihdatum != null
	 * 
	 * @ensure #getEntleiher() == entleiher
	 * @ensure #getMedium() == medium
	 * @ensure #getAusleihdatum() == ausleihdatum
	 */
	public Vormerkkarte(Medium medium, List<Kunde> vormerker) {
		assert medium != null : "Vorbedingung verletzt: medium != null";
		assert vormerker != null : "Vorbedingung verletzt: medium != null";
		_medium = medium;
		_vormerker = vormerker;
	}

	/**
	 * Gibt den Entleiher zurück.
	 * 
	 * @return den Kunden, der das Medium entliehen hat.
	 * 
	 * @ensure result != null
	 */
	public List<Kunde> getVormerker() {
		return _vormerker;
	}

	public Kunde getVormerker(int position) {
		return _vormerker.get(position);
	}

	public int getAnzahlVormerker() {
		return _vormerker.size();
	}

	/**
	 * Gibt eine String-Darstellung der Verleihkarte (enhält Zeilenumbrüche)
	 * zurück.
	 * 
	 * @return Eine formatierte Stringrepäsentation der Verleihkarte. Enthält
	 *         Zeilenumbrüche.
	 * 
	 * @ensure result != null
	 */
	public String getFormatiertenString() {
		String s = "";
		for (Kunde kunde : _vormerker) {
			s += kunde;
		}
		return s;
	}

	public Medium getMedium() {
		return _medium;
	}

	// @Override
	// public int hashCode()
	// {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result
	// + ((_ausleihdatum == null) ? 0 : _ausleihdatum.hashCode());
	// result = prime * result
	// + ((_entleiher == null) ? 0 : _entleiher.hashCode());
	// result = prime * result + ((_medium == null) ? 0 : _medium.hashCode());
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj)
	// {
	// boolean result = false;
	// if (obj instanceof Vormerkkarte)
	// {
	// Vormerkkarte other = (Vormerkkarte) obj;
	//
	// if (other.getAusleihdatum().equals(_ausleihdatum)
	// && other.getEntleiher().equals(_entleiher)
	// && other.getMedium().equals(_medium))
	//
	// result = true;
	// }
	// return result;
	// }

	@Override
	public String toString() {
		return getFormatiertenString();
	}

	public void add(Kunde kunde) {
		_vormerker.add(kunde);
	}

	public void removeAusleiher() {
			_vormerker.remove(0);
	}
}
