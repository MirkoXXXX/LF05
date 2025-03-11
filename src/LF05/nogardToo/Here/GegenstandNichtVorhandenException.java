package LF05.nogardToo.Here;

/**
 * Die Exceptionklasse, die geworfen wird, wenn ein Gegenstand nicht vorhanden ist.
 */
public class GegenstandNichtVorhandenException extends Exception {
	
	private String meldung;
	
	/**
	 * Konstruktor.
	 * @param meldung	Die Fehlermeldung.
	 */
	public GegenstandNichtVorhandenException(String meldung) {
		this.meldung = meldung;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return meldung;
	}

}
