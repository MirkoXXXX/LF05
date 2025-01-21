package LF05.rolegame;

public abstract class GameCharacter {

    private String name;
    private int strength;

    public GameCharacter(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void eat() {
        strength += 10;
    }

    public void run() throws MissingStrengthException {
        if (getStrength() < 2) {
            throw new MissingStrengthException("laufen",getName());
        } else {
            strength--;
        }
    }

    public void climb() throws MissingStrengthException {
        if (getStrength() < 2) {
            throw new MissingStrengthException("klettern",getName());
        } else {
            strength -= 2;
        }
    }

    public void fight() throws MissingStrengthException {
        if (getStrength() < 2) {
            throw new MissingStrengthException("k�mpfen",getName());
        } else {
            strength -= 3;
        }
    }

    @Override
    public String toString() {
        return  "Name:" + name + ",\n" +
                "Strength: " + strength;
    }
}
