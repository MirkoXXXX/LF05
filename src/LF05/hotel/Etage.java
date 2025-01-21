package LF05.hotel;

import java.util.ArrayList;

public class Etage {
    public String name;
    private ArrayList<Zimmer> zimmerListe;

    public Etage(String name) {
        this.name = name;
        zimmerListe = new ArrayList<Zimmer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Zimmer> getZimmerListe() {
        return zimmerListe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAnzahlZimmer() {
        return zimmerListe.size();
    }

    public Integer getAnzahlZimmerFrei() {
        int x = 0;
        for (Zimmer zimmer: zimmerListe ) {
            if ( zimmer.getAnzahlGaeste() < 1) {
                x++;
            }
        }
        return x;
    }

    public Integer getAnzahlGaeste() {
        int x = 0;
        for (Zimmer zimmer: zimmerListe ) {
            x += zimmer.getAnzahlGaeste();
        }
        return x;
    }

    @Override
    public String toString() {
        return "Etage{" +
                "name='" + name + '\'' +
                ", zimmerListe=" + zimmerListe.toString() +
                '}';
    }
}
