package LF05.fussball;

public class GameBreakException extends Exception{

    private int gametime;
    private String reason;

    public GameBreakException(int gametime, String reason) {
        super();
        this.reason = reason;
        this.gametime = gametime;
    }

    public int getGametime() {
        return gametime;
    }

    @Override
    public String getMessage() {
        return "Spiel beendet aufgrund von " + reason + " bei Minute " + gametime + ".";
    }
}
