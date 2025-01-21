package LF05.tresor;

public abstract class Gegenstand {
    final private int id;
    double value;

    public Gegenstand(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Gegenstand{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
