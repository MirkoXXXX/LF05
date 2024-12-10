package LF05.fussball;

public class Ergebnis {

    private int heimmannschaft;
    private int gastmannschaft;

    public Ergebnis() {
        heimmannschaft = 0;
        gastmannschaft = 0;
    }

    public void heimGoal() {
        heimmannschaft++;
    }

    public void gastGoal() {
        gastmannschaft++;
    }

    public int getHeimmannschaft() {
        return heimmannschaft;
    }

    public int getGastmannschaft() {
        return gastmannschaft;
    }

    @Override
    public String toString() {
        return "Tore Heimmannschaft: " + gastmannschaft
                + "\n" + "Tore Gastmannschaft: " + heimmannschaft;
    }
}