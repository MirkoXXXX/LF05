package LF05.nogard;

/**
 * Die Exceptionklasse, die geworfen wird, wenn ein Gegenstand nicht vorhanden ist.
 */
public class SpielerZuSchwachException extends Exception {
	
	private Spieler spieler;

	/**
	 * Konstruktor.
	 * @param spieler	Der Spieler, der zu schwach ist.
	 */
	public SpielerZuSchwachException(Spieler spieler) {
		this.spieler = spieler;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "!!! ACHTUNG !!!   " + spieler.getName() + ", du bist zu schwach. Dein Fitnesswert betr�gt aktuell " + spieler.getFitness() + ".";
	}

}
