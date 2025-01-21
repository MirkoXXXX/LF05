package LF05.tresor;

public class GegenstandNichtGefundenException extends Exception{

    final private int id;

    public GegenstandNichtGefundenException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getMessage() {
        return "Ihr Gegenstand mit der Id "+ id + " konnte nicht im Tresor gefunden werden.";
    }
}
