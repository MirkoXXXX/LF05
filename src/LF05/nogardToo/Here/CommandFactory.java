package LF05.nogardToo.Here;

/**
 * Diese Klasse erzeugt Instanzen von Klassen vom Typ ICommand Klasse Befehl.
 * 
 * Kann keine Instanz erzeugt werden, so reagiert die Klasse mit einer entsprechenden Fehlermeldung.
 */
public class CommandFactory {
	
	/**
	 * Erstellt eine neue Instanz eines Objekts vom Typ ICommand auf Basis einer Benutzereingabe.
	 * @param spieler	Der Spieler
	 * @param input		Die Benutzereingabe.
	 * @return			Das erstellte Objekt vom Typ ICommand.
	 * @throws BefehlUnbekanntException	Wird geworfen, wenn keine Instanz eines Befehls erzeugt werden kann. Gr�nde k�nnen sein:
	 * 									- Kein Befehl eingegeben.
	 * 									- Unbekannter Befehl eingegeben.
	 * 									- Unbekannte oder nicht eingegebene Richtung beim Befehl "go".
	 */
	public static ICommand createCommand(Spieler spieler, String input) throws BefehlUnbekanntException {
		// Abbruch bei fehlender Eingabe.
        if(input == null || input.trim().equals("")) {
            throw new BefehlUnbekanntException("Du hast keinen Befehl eingegeben.");
        }
        // Befehl aufsplitten in die einzelnen Befehlsteile
		String[] befehlArray = input.trim().split(" ");
        // Auswerten des Befehlsworts
		ICommand command = null;
        String befehlWort = befehlArray[0].trim().toLowerCase();
        switch (befehlWort) {
			case "eat":
	        	command = createCommandEat(spieler, befehlArray);
				break;
			case "go":
	        	command = createCommandGo(spieler, befehlArray);
				break;
			case "help":
				command = createCommandHelp();
				break;
			case "info":
				command = createCommandInfo(spieler);
				break;
			case "put":
	        	command = createCommandPut(spieler, befehlArray);
				break;
			case "quit":
				command = createCommandQuit();
				break;
			case "take":
	        	command = createCommandTake(spieler, befehlArray);
				break;
			default:
        		throw new BefehlUnbekanntException("Ich wei� nicht, was du meinst ...");
		}
		return command;
	}

	/**
	 * Erstellt ein CommandEat-Objekt.
	 * @param spieler		Der Spieler, der Nahrung verzehren soll.
	 * @param befehlArray	Die Benutzereingabe als Array der Einzelw�rter.
	 * @return				Das erstellte Objekt.
	 * @throws BefehlUnbekanntException	Wird geworfen, wenn keine Instanz eines Befehls erzeugt werden kann. Gr�nde k�nnen sein:
	 * 									- Nahrung existiert nicht.
	 */
	private static ICommand createCommandEat(Spieler spieler, String[] befehlArray) throws BefehlUnbekanntException {
		ICommand command = null;
    	if (befehlArray.length >= 2) {
        	String nahrung = befehlArray[1].trim();
			command = new CommandEat(spieler, nahrung);
    	}
    	else {
    		throw new BefehlUnbekanntException("Erg�nze deinen Befehl um die Nahrung, die verzehrt werden soll.");
    	}
		return command;
	}

	/**
	 * Erstellt ein CommandGo-Objekt.
	 * @param spieler		Der Spieler, der den Bereich wechseln soll.
	 * @param befehlArray	Die Benutzereingabe als Array der Einzelw�rter.
	 * @return				Das erstellte Objekt.
	 * @throws BefehlUnbekanntException	Wird geworfen, wenn keine Instanz eines Befehls erzeugt werden kann. Gr�nde k�nnen sein:
	 * 									- Richtung ist nicht korrekt.
	 * 									- Richtung fehlt.
	 */
	private static ICommand createCommandGo(Spieler spieler, String[] befehlArray) throws BefehlUnbekanntException {
		ICommand command = null;
    	if (befehlArray.length >= 2) {
        	String richtung = befehlArray[1].trim();
        	// Pr�fen der angegebenen Richtung per Schleife �ber Enum aller Richtungen
        	for (Richtungen r : Richtungen.values()) {
				if (r.name().equalsIgnoreCase(richtung)) {
					command = new CommandGo(spieler, r);
					break;
				}
        	}
        	if (command == null) {
        		throw new BefehlUnbekanntException("Gib eine korrekte Richtung an.");
        	}
    	}
    	else {
    		throw new BefehlUnbekanntException("Erg�nze deinen Befehl um die Richtung, in die du dich bewegen m�chtest.");
    	}
		return command;
	}
	
	/**
	 * Erstellt ein CommandHelp-Objekt.
	 * @return	Das erstellte Objekt.
	 */
	private static ICommand createCommandHelp() {
		return new CommandHelp();
	}
	
	/**
	 * Erstellt ein CommandInfo-Objekt.
	 * @param spieler	Der Spieler, dessen Info ausgegeben werden soll.
	 * @return Das erstellte Objekt.
	 */
	private static ICommand createCommandInfo(Spieler spieler) {
		return new CommandInfo(spieler);
	}

	/**
	 * Erstellt ein CommandPut-Objekt.
	 * @param spieler		Der Spieler, der einen Gegenstand ablegen soll.
	 * @param befehlArray	Die Benutzereingabe als Array der Einzelw�rter.
	 * @return				Das erstellte Objekt.
	 * @throws BefehlUnbekanntException	Wird geworfen, wenn keine Instanz eines Befehls erzeugt werden kann. Gr�nde k�nnen sein:
	 * 									- Gegenstand existiert nicht.
	 */
	private static ICommand createCommandPut(Spieler spieler, String[] befehlArray) throws BefehlUnbekanntException {
		ICommand command = null;
    	if (befehlArray.length >= 2) {
        	String gegenstand = befehlArray[1].trim();
			command = new CommandPut(spieler, gegenstand);
    	}
    	else {
    		throw new BefehlUnbekanntException("Erg�nze deinen Befehl um den Gegenstand, der abgelegt werden soll.");
    	}
		return command;
	}
	
	/**
	 * Erstellt ein CommandQuit-Objekt.
	 * @return	Das erstellte Objekt.
	 */
	private static ICommand createCommandQuit() {
		return new CommandQuit();
	}

	/**
	 * Erstellt ein CommandTake-Objekt.
	 * @param spieler		Der Spieler, der einen Gegenstand aufnehmen soll.
	 * @param befehlArray	Die Benutzereingabe als Array der Einzelw�rter.
	 * @return				Das erstellte Objekt.
	 * @throws BefehlUnbekanntException	Wird geworfen, wenn keine Instanz eines Befehls erzeugt werden kann. Gr�nde k�nnen sein:
	 * 									- Gegenstand existiert nicht.
	 */
	private static ICommand createCommandTake(Spieler spieler, String[] befehlArray) throws BefehlUnbekanntException {
		ICommand command = null;
    	if (befehlArray.length >= 2) {
        	String gegenstand = befehlArray[1].trim();
			command = new CommandTake(spieler, gegenstand);
    	}
    	else {
    		throw new BefehlUnbekanntException("Erg�nze deinen Befehl um den Gegenstand, der aufgenommen werden soll.");
    	}
		return command;
	}

}
