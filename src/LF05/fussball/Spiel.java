package LF05.fussball;

public class Spiel {

    private Mannschaft gastmannschaft;
    private Mannschaft heimmannschaft;
    private Ergebnis ergebnis;
    private Spielverlauf history;

    public Spiel(Mannschaft gastmannschaft, Mannschaft heimmannschaft) {
        this.gastmannschaft = gastmannschaft;
        this.heimmannschaft = heimmannschaft;
        this.ergebnis = new Ergebnis();
        this.history = new Spielverlauf(gastmannschaft.getName(),heimmannschaft.getName());
    }


    public Mannschaft getGastmannschaft() {
        return gastmannschaft;
    }

    public Mannschaft getHeimmannschaft() {
        return heimmannschaft;
    }

    public Ergebnis getErgebnis() {
        return ergebnis;
    }

    public Spielverlauf getHistory() {
        return history;
    }

    @Override
    public String toString() {
        return getHistory().toString() + getErgebnis().toString();
    }
}
