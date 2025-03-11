package LF05.nogardToo.Here;

/**
 * Diese Klasse modelliert einen Gegenstand.
 */
public class Gegenstand {
	
	private String name;
	private String beschreibung;
	private double gewicht;
	
	/**
	 * Konstruktor.
	 * @param name			Der Name des Gegenstandes.
	 * @param beschreibung	Die Beschreibung des Gegenstandes.
	 * @param gewicht		Das Gewicht des Gegenstandes in kg.
	 */
	public Gegenstand(String name, String beschreibung, double gewicht) {
		this.name = name;
		this.beschreibung = beschreibung;
		this.gewicht = gewicht;
	}

	/**
     * Liefert den Namen des Gegenstandes.
     * @return	Der Name des Gegenstandes.
	 */
	public String getName() {
		return name;
	}

    /**
     * Liefert die Beschreibung des Gegenstandes.
     * @return	Die Beschreibung des Gegenstandes.
     */
	public String getBeschreibung() {
		return beschreibung;
	}

	/**
     * Liefert das Gewicht des Gegenstandes in kg.
     * @return	Das Gewicht des Gegenstandes in kg.
	 */
	public double getGewicht() {
		return gewicht;
	}
	
	/**
	 * Gibt die Informationen �ber den Gegenstand zur�ck.
	 * @return	Die Informationen �ber den Gegenstand.
	 */
	public String getInfo() {
		return name + " " + beschreibung + " mit einem Gewicht von " + gewicht + " kg";
	}

}
