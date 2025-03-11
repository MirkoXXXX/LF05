package LF05.nogard;

import LF05.tresor.GegenstandNichtGefundenException;

import java.util.LinkedList;
import java.util.List;

public class Spieler {
    private String name;
    private float tragkraft;
    private int fitness;
    private List<Gegenstand> gegenstaende = new LinkedList<>();
    private Bereich bereich;
    private final int FITNESS_MAX = 5000;
    private final int VERBRAUCH_GEHEN = 500;

    public Spieler(String name, float tragkraft, int fitness, Bereich bereich) {
        this.name = name;
        this.tragkraft = tragkraft;
        this.fitness = fitness;
        this.bereich = bereich;
    }

    public String getName() {
        return name;
    }

    public float getTragkraft() {
        return tragkraft;
    }

    public int getFitness() {
        return fitness;
    }

    public List<Gegenstand> getGegenstaende() {
        return gegenstaende;
    }

    public Bereich getBereich() {
        return bereich;
    }

    public float getTraglast() {
        float capacity = 0.0f;
        for (Gegenstand gegenstand : gegenstaende) {
            capacity += gegenstand.getGewicht();
        }

        return capacity;
    }

    public void aufnehmenGegenstand(String nameGegenstand) throws GegenstandNichtVorhandenException, GegenstandZuSchwerException {
        Gegenstand gegenstand = bereich.suchenGegenstand(nameGegenstand);
        if (gegenstand instanceof Nahrung == false) {
            double traglast = getTraglast();
            if(traglast + gegenstand.getGewicht() <= tragkraft) {
                bereich.entfernenGegenstand(gegenstand);
                gegenstaende.add(gegenstand);
            }
            else {
                throw new GegenstandZuSchwerException(gegenstand);
            }
        }
        else {
            throw new GegenstandNichtVorhandenException("In diesem Bereich befindet sich leider kein Gegenstand mit dem Namen " + nameGegenstand + ".");
        }
    }

    public void ablegenGegenstand(String nameGegenstand) throws GegenstandNichtVorhandenException {
        Gegenstand gegenstand = null;
        for (Gegenstand g : gegenstaende) {
            if (g.getName().equalsIgnoreCase(nameGegenstand)) {
                gegenstand = g;
                break;
            }
        }
        if (gegenstand != null) {
            gegenstaende.remove(gegenstand);
            bereich.platzierenGegenstand(gegenstand);
        }
        else {
            throw new GegenstandNichtVorhandenException("Du besitzt leider keinen Gegenstand mit dem Namen " + nameGegenstand + ".");
        }
    }

    public void essen(String nameNahrung) throws GegenstandNichtVorhandenException, SpielerSattException {
        Gegenstand gegenstand = bereich.suchenGegenstand(nameNahrung);
        if (gegenstand instanceof Nahrung) {
            Nahrung nahrung = (Nahrung)gegenstand;
            if (fitness + nahrung.getNaerwert() <= FITNESS_MAX) {
                fitness = fitness + nahrung.getNaerwert();
            }
            else {
                fitness = FITNESS_MAX;
                throw new SpielerSattException(this);
            }
        }
        else {
            throw new GegenstandNichtVorhandenException("An diesem Ort befindet sich keine Nahrung mit dem Namen " + nameNahrung + ".");
        }
    }

    public void gehenInBereich(Bereich bereich) throws SpielerZuSchwachException {
        if (fitness - VERBRAUCH_GEHEN >= 0) {
            this.bereich = bereich;
            fitness = fitness - VERBRAUCH_GEHEN;
        }
        else {
            throw new SpielerZuSchwachException(this);
        }
    }


    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name).append("\n");
        sb.append("Tragkraft: ").append(tragkraft).append("\n");
        sb.append("Fitness: ").append(fitness).append("\n");
        sb.append("Gegenstaende:\n");
        for (Gegenstand gegenstand : gegenstaende) {
            sb.append(gegenstand.getInfo()).append("\n");
        }
        sb.append("Bereich: ").append(bereich.getInfo()).append("\n");

        return sb.toString();
    }
}