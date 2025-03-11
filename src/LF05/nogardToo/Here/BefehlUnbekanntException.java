package LF05.nogardToo.Here;

/**
 * Die Exceptionklasse, die geworfen wird, wenn ein Befehl unbekannt ist.
 */
public class BefehlUnbekanntException extends Exception {
	
	private String meldung;
	
	/**
	 * Konstruktor.
	 * @param meldung	Die Fehlermeldung.
	 */
	public BefehlUnbekanntException(String meldung) {
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
