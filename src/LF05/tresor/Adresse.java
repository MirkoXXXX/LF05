package LF05.tresor;

public class Adresse {

    String street;
    String hausNr;
    String plz;
    String ort;

    public Adresse(String street, String hausNr, String plz, String ort) {
        this.street = street;
        this.hausNr = hausNr;
        this.plz = plz;
        this.ort = ort;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHausNr() {
        return hausNr;
    }

    public void setHausNr(String hausNr) {
        this.hausNr = hausNr;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "Strasse: " + street + '\'' +
                "Hausnummer: " + hausNr + '\'' +
                "PLZ: " + plz + '\'' +
                "Ort: " + ort + '\'';
    }
}
