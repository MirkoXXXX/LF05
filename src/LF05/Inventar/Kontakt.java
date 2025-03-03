package LF05.Inventar;

public class Kontakt {
    private String mail;
    private String telBuero;
    private String telMobil;

    public Kontakt(String mail, String telBuero, String telMobil) {
        this.mail = mail;
        this.telBuero = telBuero;
        this.telMobil = telMobil;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelBuero() {
        return telBuero;
    }

    public void setTelBuero(String telBuero) {
        this.telBuero = telBuero;
    }

    public String getTelMobil() {
        return telMobil;
    }

    public void setTelMobil(String telMobil) {
        this.telMobil = telMobil;
    }

    @Override
    public String toString() {
        return "Kontakt{" +
                "mail='" + mail + '\'' +
                ", telBuero='" + telBuero + '\'' +
                ", telMobil='" + telMobil + '\'' +
                '}';
    }
}
