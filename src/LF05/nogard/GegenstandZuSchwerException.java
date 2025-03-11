package LF05.nogard;

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
