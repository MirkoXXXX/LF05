package LF05.fussball;

public class Spieler extends Person{

    private int strength;
    private int torschuss;
    private int motivation;
    private int goals;

    public Spieler(String name, int alter, int strength, int torschuss, int motivation) {
        super(name,alter);
        setStrength(strength);
        setMotivation(motivation);
        setTorschuss(torschuss);
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength > 0 && strength < 11) {
            this.strength = strength;
        } else if (strength > 0) {
            this.strength = 1;
        } else {
            this.strength = 10;
        }
    }

    public int getTorschuss() {
        return torschuss;
    }

    public void setTorschuss(int torschuss) {
        if (torschuss >= 0 && torschuss < 11) {
            this.torschuss = torschuss;
        } else if (torschuss >= 0) {
            this.torschuss = 0;
        } else {
            this.torschuss = 10;
        }
    }

    public int getMotivation() {
        return motivation;
    }

    public void setMotivation(int motivation) {
        if (motivation > 0 && motivation < 11) {
            this.motivation = motivation;
        } else if (motivation > 0) {
            this.motivation = 1;
        } else {
            this.motivation = 10;
        }
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void addGoal() {
        this.goals++;
    }

    @Override
    public String toString() {
        return "Name: " + getName() + ",\n" +
                "Alter: " + getAlter() + ",\n" +
                "Stärke: " + strength + ",\n" +
                "Torschuss: " + torschuss + ",\n" +
                "Motivation: " + motivation + ",\n" +
                "Geschossene Tore: " + goals;
    }
}