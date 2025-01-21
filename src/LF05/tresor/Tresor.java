package LF05.tresor;

import java.util.ArrayList;

public class Tresor {

    private ArrayList<Gegenstand> storage;
    private Hersteller manufacturer;

    public Tresor(Hersteller manufacturer) {
        storage = new ArrayList<>();
        this.manufacturer = manufacturer;
    }

    public Gegenstand getGegenstand(int id) throws GegenstandNichtGefundenException {
        for (Gegenstand g : storage) {
            if (g.getId() == id) {
                return g;
            }
        }
        throw new GegenstandNichtGefundenException(id);
    }

    public void removeGegenstand(Gegenstand g) throws GegenstandNichtGefundenException {
        if (!storage.remove(g)) {
            throw new GegenstandNichtGefundenException(g.getId());
        }
    }

    public void addGegenstand(Gegenstand g){
        storage.add(g);
    }

    public double calculateAssets() {
        double sum = 0.0;
        for (Gegenstand g : storage) {
            sum += g.getValue();
        }
        return sum;
    }

    public Hersteller getManufacturer() {
        return manufacturer;
    }

    @Override
    public String toString() {
        return "Tresor{" +
                "storage=" + storage +
                ", manufacturer=" + manufacturer +
                '}';
    }
}
