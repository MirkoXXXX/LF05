package LF05.hotel;

import java.util.ArrayList;
import java.util.List;

public class Zimmer {
    private Integer nr;
    private List<Gast> gastListe;

    public Zimmer(Integer nr) {
        this.nr = nr;
        gastListe = new ArrayList<>();
    }

    public int getNr() {
        return nr;
    }

    public List<Gast> getGastListe() {
        return gastListe;
    }

    public Integer getAnzahlGaeste() {
        return gastListe.size();
    }

    public void checkIn(Gast gast) {
        gastListe.add(gast);
    }

    public void checkOut(Gast gast) {
        if (gastListe.contains(gast)) {
            gastListe.remove(gast);
        } else {
                //throw new Exception("Dieser Gast ist nicht in diesem Raum vorhanden.");
        }
    }
}
