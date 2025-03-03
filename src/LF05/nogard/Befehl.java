package LF05.nogard;

public class Befehl {
    private String befehlswort;
    private String befehlszusatz;

    public Befehl(String befehlswort) {
        this.befehlswort = befehlswort;
        this.befehlszusatz = null;
    }

    public Befehl(String befehlswort, String befehlszusatz) {
        this.befehlswort = befehlswort;
        this.befehlszusatz = befehlszusatz;
    }

    public String getBefehlswort() {
        return befehlswort;
    }
    public String getBefehlszusatz() {
        return befehlszusatz;
    }
}
