package LF05.fussball;

public class Torwart extends Spieler{

    private int reaktion;

    public Torwart(String name, int alter, int strength, int motivation, int reaktion) {
        super(name, alter, strength, 0 , motivation);
        this.reaktion = reaktion;
    }

    public int getReaktion() {
        return reaktion;
    }

    public void setReaktion(int reaktion) {
        this.reaktion = reaktion;
    }

    @Override
    public String toString() {
        return super.toString()+",\nTorschussreaktion: " + reaktion;
    }
}
