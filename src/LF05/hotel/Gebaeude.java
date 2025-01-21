package LF05.hotel;

import java.util.ArrayList;

public class Gebaeude {
    private String name;
    private ArrayList<Etage> etagenListen;

    public Gebaeude (String name) {
        this.name = name;
        etagenListen = new ArrayList<Etage>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Etage> getEtagenListen() {
        return etagenListen;
    }

    public Integer getAnzahlEtagen() {
        return etagenListen.size();
    }

    public Integer getAnzahlZimmer() {
        int zimmer = 0;
        for (Etage etage : etagenListen) {
            zimmer += etage.getAnzahlZimmer();
        }
        return zimmer;
    }
}
