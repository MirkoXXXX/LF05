package LF05.fussball;

public class Trainer extends Person{

    private int erfahrung;

    public Trainer(String name, int alter, int erfahrung) {
        super(name,alter);
        if (erfahrung > 0 && erfahrung < 11) {
            this.erfahrung = erfahrung;
        } else if (erfahrung > 0) {
            this.erfahrung = 1;
        } else {
            this.erfahrung = 10;
        }
    }

    public int getErfahrung() {
        return erfahrung;
    }

    public void setErfahrung(int erfahrung) {
        if (erfahrung > 0 && erfahrung < 11) {
            this.erfahrung = erfahrung;
        } else if (erfahrung > 0) {
            this.erfahrung = 1;
        } else {
            this.erfahrung = 10;
        }
    }

    @Override
    public String toString() {
        return "Name: " + super.getName() + ",\n" +
                "Alter: " + super.getAlter() + ",\n" +
                "Erfahrung: " + erfahrung;
    }
}
