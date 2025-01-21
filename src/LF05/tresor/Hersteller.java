package LF05.tresor;

public class Hersteller {

    String firstname;
    String lastname;

    Adresse adress;

    public Hersteller(String firstname, String lastname, Adresse adress) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.adress = adress;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Adresse getAdress() {
        return adress;
    }

    public void setAdress(Adresse adress) {
        this.adress = adress;
    }
}
