package LF05.fussball;

public class Spielverlauf {

    private StringBuilder history;

    public Spielverlauf(String gastmannschaft, String heimmannschaft) {
        history = new StringBuilder();
        history.append("Spiel ").append(gastmannschaft).append(" vs ").append(heimmannschaft).append("!\n");
        br();
    }

    public String getHistory() {
        return history.toString();
    }

    public void addEvent(String event) {
        history.append(event).append("\n");
    }

    public void br() {
        history.append("-".repeat(8)).append("\n");
    }

    @Override
    public String toString() {
        return getHistory();
    }
}