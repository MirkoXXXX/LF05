package LF05.nogardToo.Here;

/**
 * Diese Klasse modelliert Nahrung als einen speziellen Gegenstand.
 */
public class Nahrung extends Gegenstand {

	private int naehrwert;
	
	/**
	 * Konstruktor
	 * @param name			Der Name der Nahrung.
	 * @param beschreibung	Die Beschreibung der Nahrung.
	 * @param naehrwert		Der N�hrwert der Nahrung in Kilokalorien (kcal).
	 */
	public Nahrung(String name, String beschreibung, int naehrwert) {
		super(name, beschreibung, 0);
		this.naehrwert = naehrwert;
	}
	
	/**
     * Liefert den N�hrwert der Nahrung in Kilokalorien (kcal).
     * @return	Der N�hrwert der Nahrung in Kilokalorien (kcal).
	 */
	public int getNaehrwert() {
		return naehrwert;
	}
	
	/**
	 * Gibt die Informationen �ber die Nahrung zur�ck.
	 * @return	Die Informationen �ber die Nahrung.
	 */
	@Override
	public String getInfo() {
		return getName() + " " + getBeschreibung() + " mit einem N�hrwert von " + naehrwert + " kcal";
	}

}
