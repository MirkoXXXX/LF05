package LF05.hotel;

public class Gast {
    private Adresse adresse;
    private String nachname;
    private String vorname;

    private Integer gastNr;
    public Gast (int gastNr, Adresse adresse, String vorname, String nachname) {
        this.adresse = adresse;
        this.nachname = nachname;
        this.vorname = vorname;
        this.gastNr = gastNr;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Integer getGastNr() {
        return gastNr;
    }
}
