package LF05.rolegame;

public class MissingStrengthException extends Exception{

    private String aktion;
    private String name;

    public MissingStrengthException(String aktion, String name) {
        super();
        this.aktion = aktion;
        this.name = name;
    }

    @Override
    public String getMessage() {
        return "Character "+name+" ist zu schwach um zu"+aktion+"!";
    }
}
