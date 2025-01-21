package LF05.hotel.exceptions;

public class GastNichtVorhandenException extends Exception {

    Integer nr;

    public GastNichtVorhandenException(Integer nr) {
        super();
        this.nr = nr;
    }

    @Override
    public String getMessage() {
        return "Der Gast mit der Nummer " + nr + " ist nicht vorhanden.\n";
    }
}
