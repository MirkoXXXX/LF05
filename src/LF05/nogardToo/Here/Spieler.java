package LF05.nogardToo.Here;

import java.util.LinkedList;
import java.util.List;

/**
 * Diese Klasse modelliert einen Spieler.
 * 
 * Wechselt der Spieler den Bereich, so kostet das Energie, d.h. sein Fitnesswert sinkt. 
 * Hat er nicht mehr genug Energie, so kann er den Wechsel nicht durchf�hren.
 * 
 * Der Spieler kann Nahrung verzehren und damit Energie auftanken. 
 * Allerdings ist die Aufnahme von Nahrung begrenzt.
 */
public class Spieler {
	
	private final int VERBRAUCH_GEHEN = 500;
	private final int FITNESS_Max = 5000;
	
	private String name;
	private double traglastMax;
	private int fitness;
	private Bereich bereich;
	private List<Gegenstand> gegenstaende;
	
	/**
	 * Konstruktor.
	 * @param name			Der Name des Spielers.
	 * @param traglastMax	Die maximale Traglast, die der Spieler bew�ltigen kann.
	 * @param fitness		Der Fitnesswert des Spielers.
	 * @param bereich		Der Bereich, in dem sich der Spieler befindet.
	 */
	public Spieler(String name, double traglastMax, int fitness, Bereich bereich) {
		this.name = name;
		this.traglastMax = traglastMax;
		this.fitness = fitness;
		this.bereich = bereich;
		gegenstaende = new LinkedList<>();
	}

	/**
	 * Liefert den Namen des Spielers.
	 * @return 	Der Name des Spielers
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Liefert die aktuelle Traglast als Summe aller Gegenst�nde, die der Spieler tr�gt.
	 * @return	Die aktuelle Traglast.
	 */
	public double getTraglast() {
		double traglast = 0;
		for (Gegenstand gegenstand : gegenstaende) {
			traglast = traglast + gegenstand.getGewicht();
		}
		return traglast;
	}

	/**
	 * Liefert die maximale Traglast des Spielers.
	 * @return	Die maximale Traglast des Spielers.
	 */
	public double getTraglastMax() {
		return traglastMax;
	}

	/**
	 * Liefert den Fitnesszustand des Spielers.
	 * @return	Der Fitnesszustand des Spielers.
	 */
	public int getFitness() {
		return fitness;
	}

	/**
	 * Liefert den aktuellen Bereich des Spielers.
	 * @return	Der aktuelle Bereich des Spielers.
	 */
	public Bereich getBereich() {
		return bereich;
	}
	
	/**
	 * Gibt die Informationen �ber den Spieler zur�ck.
	 * @return	Die Informationen �ber den Spieler.
	 */
	public String getInfo() {
		StringBuilder info = new StringBuilder();
		// Begr��ung ausgeben.
		info.append(name + ", dein Fitnesswert betr�gt aktuell " + fitness + ".");
		// Alle gegenst�nde ausgeben, wenn vorhanden.
		if (gegenstaende.size() > 0) {
			info.append("\nDu tr�gst folgenden Gegenst�nde mit dir:");
			for (Gegenstand gegenstand : gegenstaende) {
				info.append("\n\t" + gegenstand.getInfo());
			}
		}
		// Info �ber den aktuellen Bereich ausgeben.
		info.append(bereich.getInfo());
        return info.toString();
	}
	
	/**
	 * Geht in einen neuen Bereich, wenn die Kraft dazu reicht.
	 * @param bereich	Der neue Bereich, in den der Spieler gehen soll.
	 * @throws SpielerZuSchwachException	Wird geworfen, wenn der Spieler zu schwach ist, in den Bereich zu gehen.
	 */
	public void gehenInBereich(Bereich bereich) throws SpielerZuSchwachException {
		if (fitness - VERBRAUCH_GEHEN >= 0) {
			this.bereich = bereich;
			fitness = fitness - VERBRAUCH_GEHEN;
		}
		else {
			throw new SpielerZuSchwachException(this);
		}
	}
	
	/**
	 * Nimmt einen Gegenstand auf, wenn dadurch die maximale Tragkraft nicht �berschritten wird.
	 * Nahrung kann nicht aufgenommen werden.
	 * @param nameGegenstand	Der Name des aufzunehmende Gegenstandes.
	 * @throws GegenstandNichtVorhandenException	Wird geworfen, wenn sich der aufzunehmende Gegenstand nicht im Bereich befindet.
	 * @throws GegenstandZuSchwerException			Wird geworfen, wenn der aufzunehmende Gegenstand die maximale Tragkraft �berschreitet.
	 */
	public void aufnehmenGegenstand(String nameGegenstand) throws GegenstandNichtVorhandenException, GegenstandZuSchwerException {
		Gegenstand gegenstand = bereich.suchenGegenstand(nameGegenstand);
		if (gegenstand instanceof Nahrung == false) {
			double traglast = getTraglast();
			if(traglast + gegenstand.getGewicht() <= traglastMax) {
				bereich.entfernenGegenstand(gegenstand);
				gegenstaende.add(gegenstand);
			}
			else {
				throw new GegenstandZuSchwerException(gegenstand);
			}
		}
		else {
			throw new GegenstandNichtVorhandenException("In diesem Bereich befindet sich leider kein Gegenstand mit dem Namen " + nameGegenstand + ".");
		}
	}
	
	/**
	 * Legt einen Gegenstand ab.
	 * @param nameGegenstand	Der Name des abzulegenden Gegenstandes.
	 * @throws GegenstandNichtVorhandenException	Wird geworfen, wenn kein Gegenstand den angegebenen Namen hat.
	 */
	public void ablegenGegenstand(String nameGegenstand) throws GegenstandNichtVorhandenException {
		Gegenstand gegenstand = null;
		for (Gegenstand g : gegenstaende) {
			if (g.getName().equalsIgnoreCase(nameGegenstand)) {
				gegenstand = g;
				break;
			}
		}
		if (gegenstand != null) {
			gegenstaende.remove(gegenstand);
			bereich.platzierenGegenstand(gegenstand);
		}
		else {
			throw new GegenstandNichtVorhandenException("Du besitzt leider keinen Gegenstand mit dem Namen " + nameGegenstand + ".");
		}
	}
	
	/**
	 * Verzehrt Nahrung. 
	 * Ein Spieler kann allerdings nicht mehr essen, als er Hunger hat.
	 * @param nameNahrung	Der Name der zu verzehrenden Nahrung.
	 * @throws GegenstandNichtVorhandenException	Wird geworfen, wenn es die zu verzehrende Nahrung nicht im Bereich gibt.
	 * @throws SpielerSattException					Wird geworfen, wenn der Spieler satt ist.
	 */
	public void essen(String nameNahrung) throws GegenstandNichtVorhandenException, SpielerSattException {
		Gegenstand gegenstand = bereich.suchenGegenstand(nameNahrung);
		if (gegenstand instanceof Nahrung) {
			Nahrung nahrung = (Nahrung)gegenstand;
			if (fitness + nahrung.getNaehrwert() <= FITNESS_Max) {
				fitness = fitness + nahrung.getNaehrwert();
			}
			else {
				fitness = FITNESS_Max;
				throw new SpielerSattException(this);
			}
		}
		else {
			throw new GegenstandNichtVorhandenException("An diesem Ort befindet sich keine Nahrung mit dem Namen " + nameNahrung + ".");
		}
	}

}
