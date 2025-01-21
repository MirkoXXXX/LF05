package LF05.hotel.exceptions;

import LF05.hotel.Gast;

public class GastSchonVorhandenException extends Exception{

    Gast gast;

    public GastSchonVorhandenException(Gast gast) {
        super();
        this.gast = gast;
    }

    @Override
    public String getMessage() {
        return "Der Gast \" " + gast.getVorname() + ", " + gast.getNachname() + " \" ist schon vorhanden.\n";
    }
}
