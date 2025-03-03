package LF05.nogard;

public class BefehlFactory {
    static public Befehl createBefehl(String eingabe) throws BefehlUnbekanntException{
        if (eingabe == null || eingabe.isEmpty()) {
            throw new BefehlUnbekanntException("kein Befehl angegeben");
        }

        eingabe = eingabe.toLowerCase().trim();
        String[] befehl = eingabe.split(" ");

        switch (befehl[0]){
            case "go":
                if (befehl.length != 2) {
                    throw new BefehlUnbekanntException("kein korrekten Befehlszusatz angegeben");
                }
                for (Richtungen richtung : Richtungen.values()) {
                    if (befehl[1].equalsIgnoreCase(richtung.name())) {
                        return new Befehl("go", befehl[1]);
                    }
                }
                throw new BefehlUnbekanntException("Unbekannte Richtung: " + befehl[1]);
            case "help":
                return new Befehl("help");
            case "quit":
                return new Befehl("quit");
            default:
                throw new BefehlUnbekanntException("den Befehl gibt es nicht");
        }
    }
}
