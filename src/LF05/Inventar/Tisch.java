package LF05.Inventar;

public class Tisch extends Moebelstueck{
    private double hoehe;
    private double laenge;
    private double breite;

    public Tisch(int id, String name) {
        super(id, name);
    }

    public double getHoehe() {
        return hoehe;
    }

    public void setHoehe(double hoehe) {
        this.hoehe = hoehe;
    }

    public double getLaenge() {
        return laenge;
    }

    public void setLaenge(double laenge) {
        this.laenge = laenge;
    }

    public double getBreite() {
        return breite;
    }

    public void setBreite(double breite) {
        this.breite = breite;
    }

    @Override
    public String toString() {
        return "Tisch{" +
                "Id=" + getId() +
                ", Name=" + getName() +
                ", Description=" + getDescription() +
                ", Material=" + getMaterial() +
                ", Hoehe=" + hoehe +
                ", Laenge=" + laenge +
                ", Breite=" + breite +
                '}';
    }
}
