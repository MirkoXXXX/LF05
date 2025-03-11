package LF05.nogard;

/**
 * Die Exceptionklasse, die geworfen wird, wenn eine Person satt ist.
 */
public class SpielerSattException extends Exception {
	
	private Spieler spieler;

	/**
	 * Konstruktor.
	 * @param spieler	Der Spieler, der zu schwach ist.
	 */
	public SpielerSattException(Spieler spieler) {
		super();
		this.spieler = spieler;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return spieler.getName() + ", du bist jetzt satt. Dein Fitnesswert betr�gt aktuell " + spieler.getFitness() + ".";
	}

}
