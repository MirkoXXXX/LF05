package LF05.tresor;

public class Schmuck extends Gegenstand{

    private String label;

    public Schmuck(int id, double value, String label) {
        super(id, value);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
