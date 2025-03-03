package LF05.nogard;

public class Gegenstand {
    private String name;
    private String Beschreibung;
    private float Gewicht;

    public Gegenstand(String name, String Beschreibung, float Gewicht) {
        this.name = name;
        this.Beschreibung = Beschreibung;
        this.Gewicht = Gewicht;
    }

    public String getName() {
        return name;
    }
    public String getBeschreibung() {
        return Beschreibung;
    }
    public float getGewicht() {
        return Gewicht;
    }
    public String getInfo(){
        return "";
    }
}
