package LF05.nogard;

public class Gegenstand {
    private String name;
    private String Beschreibung;
    private double Gewicht;

    public Gegenstand(String name, String Beschreibung, double Gewicht) {
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
    public double getGewicht() {
        return Gewicht;
    }

    public String getInfo() {
        return "Gegenstand{" +
                "name='" + name + '\'' +
                ", Beschreibung='" + Beschreibung + '\'' +
                ", Gewicht=" + Gewicht +
                '}';
    }
}
