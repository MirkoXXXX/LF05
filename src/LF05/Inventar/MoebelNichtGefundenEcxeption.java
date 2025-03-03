package LF05.Inventar;

public class MoebelNichtGefundenEcxeption extends RuntimeException {
    private int id;

    public MoebelNichtGefundenEcxeption(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return "Es wurde kein Moebel mit der ID " + id + " gefunden.";
    }
}
