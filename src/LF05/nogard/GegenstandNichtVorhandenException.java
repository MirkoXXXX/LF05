package LF05.nogard;

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
