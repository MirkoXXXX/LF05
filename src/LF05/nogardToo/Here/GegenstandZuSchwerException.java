package LF05.nogardToo.Here;

/**
 * Die Exceptionklasse, die geworfen wird, wenn ein Gegenstand nicht vorhanden ist.
 */
public class GegenstandZuSchwerException extends Exception {
	
	private Gegenstand gegenstand;
	
	/**
	 * Konstruktor.
	 * @param gegenstand	Der Gegenstand.
	 */
	public GegenstandZuSchwerException(Gegenstand gegenstand) {
		this.gegenstand = gegenstand;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return "Der Gegenstand " + gegenstand.getName() + " ist zu schwer.";
	}

}
