package LF05.Inventar;

public class Stuhl extends Moebelstueck{
    private double hoeheSitz;

    public Stuhl(int id, String name) {
        super(id, name);
    }

    public double getHoeheSitz() {
        return hoeheSitz;
    }

    public void setHoeheSitz(double hoeheSitz) {
        this.hoeheSitz = hoeheSitz;
    }

    @Override
    public String toString() {
        return "Tisch{" +
                "Id=" + getId() +
                ", Name=" + getName() +
                ", Description=" + getDescription() +
                ", Material=" + getMaterial() +
                ", Hoehe=" + hoeheSitz +
                '}';
    }
}
