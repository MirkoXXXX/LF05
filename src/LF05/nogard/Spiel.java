package LF05.nogard;

import java.util.Scanner;

/**
 *  Dies ist die Hauptklasse der Anwendung "Die Welt von Nogard".
 *  "Die Welt von Nogard" ist ein sehr einfaches, textbasiertes Adventure-Game, in dem sich ein Spieler durch Nogard bewegen kann.
 *  Das Spiel sollte auf jeden Fall ausgebaut werden, damit es interessanter wird!
 *  Zum Spielen muss an einer Instanz dieser Klasse die Methode "spielen()" aufgerufen werden.
 *  Diese Klasse erzeugt und initialisiert alle Objekte der Anwendung: 
 *  - Sie legt alle Bereiche an. Anschlie�end startet das Spiel. 
 *  - Sie wertet die Befehle aus und sorgt f�r ihre Ausf�hrung.
 */
public class Spiel {
	private Bereich aktiverBereich;
	private Spieler spieler;

	public Spiel(){
		erzeugeDorf();
	}

	private void erzeugeDorf() {
		// Die Bereiche erzeugen.
		Bereich friedhof = new Bereich("auf einem Friedhof, umgeben von dunklen Tannen");
		Bereich hexenhaus = new Bereich("im finsteren Hexenhaus");
		Bereich rathaus = new Bereich("im Rathaus von Nogard");
		Bereich taverne = new Bereich("in der Taverne, mit zwielichtigen Gestalten an der Theke");
		Bereich wald = new Bereich("im dunklen Stadtwald von Nogard");
		Bereich hoehle = new Bereich("in einer dunklen und feuchten H�hle");
		Bereich kraeuterkeller = new Bereich("im Kr�uterkeller der Dorfhexe");
		Bereich weinkeller = new Bereich("im Weinkeller der Taverne");

		// Die Nachbarschaften festlegen.
		friedhof.setNachbarn(Richtungen.SOUTH, hexenhaus);
		hexenhaus.setNachbarn(Richtungen.NORTH, friedhof);
		hexenhaus.setNachbarn(Richtungen.EAST, rathaus);
		hexenhaus.setNachbarn(Richtungen.SOUTH, wald);
		hexenhaus.setNachbarn(Richtungen.DOWN, kraeuterkeller);
		rathaus.setNachbarn(Richtungen.SOUTH, taverne);
		rathaus.setNachbarn(Richtungen.WEST, hexenhaus);
		taverne.setNachbarn(Richtungen.NORTH, rathaus);
		taverne.setNachbarn(Richtungen.WEST, wald);
		taverne.setNachbarn(Richtungen.DOWN, weinkeller);
		wald.setNachbarn(Richtungen.NORTH, hexenhaus);
		wald.setNachbarn(Richtungen.EAST, taverne);
		hoehle.setNachbarn(Richtungen.NORTH, kraeuterkeller);
		hoehle.setNachbarn(Richtungen.EAST, weinkeller);
		kraeuterkeller.setNachbarn(Richtungen.SOUTH, hoehle);
		kraeuterkeller.setNachbarn(Richtungen.UP, hexenhaus);
		weinkeller.setNachbarn(Richtungen.WEST, hoehle);
		weinkeller.setNachbarn(Richtungen.UP, taverne);

		// Die Gegenst�nde in die Bereiche legen.
		friedhof.platzierenGegenstand(new Gegenstand("Taschentuch", "zum Trocknen deiner Tr�nen", 0.1));
		hexenhaus.platzierenGegenstand(new Gegenstand("Kessel", "zum Kochen der Zaubertr�nke", 5.0));
		hexenhaus.platzierenGegenstand(new Gegenstand("Krug", "mit fauligem Kr�tenwasser", 5.0));
		hexenhaus.platzierenGegenstand(new Gegenstand("Schale", "mit getrockneten Kr�utern", 2.5));
		hexenhaus.platzierenGegenstand(new Nahrung("Froschschenkel", "mit ranziger Knoblauchbutter", 700));
		taverne.platzierenGegenstand(new Nahrung("Bier", "mit luftiger Krone", 500));
		taverne.platzierenGegenstand(new Nahrung("Wildschweinbraten", "mit Kl��en und klumpiger So�e", 1200));
		taverne.platzierenGegenstand(new Gegenstand("Tisch", "mit verschmierten Essensresten und dicken Kerben", 35.0));
		taverne.platzierenGegenstand(new Gegenstand("Stuhl", "mit wackligen Beinen und gebrochener Lehne", 2.5));
		wald.platzierenGegenstand(new Nahrung("Pilze", "leuchtend rot mit wei�en Punkten", 200));
		weinkeller.platzierenGegenstand(new Gegenstand("Fass", "mit lange gelagertem Rotwein", 10.0));
		hoehle.platzierenGegenstand(new Gegenstand("Spinne", "mit gro�en funkelnden Augen und acht haarigen Beinen", 0.2));
		hoehle.platzierenGegenstand(new Gegenstand("Spinnennetz", "mit Spinne", 0.3));
		hoehle.platzierenGegenstand(new Gegenstand("Skelett", "ohne Totenkopf", 7.5));

		// Den Spieler festlegen.
		spieler = new Spieler("Trollo", 20, 3000, wald);

		// Das Spielt startet im Wald.
		aktiverBereich = wald;
	}

	/**
     * Die Hauptmethode zum Spielen.
     * L�uft bis zum Ende des Spiels in einer Schleife.
     */
    public void spielen() {

		ausgebenStartText();

		// Befehle einlesen und auswerten.
        Scanner scannerZeile = new Scanner(System.in);
        boolean end = false;
        while (! end) {
            // Eingabeaufforderung anzeigen.
            System.out.print("> ");
            // Befehlszeile lesen.
            String input = scannerZeile.nextLine();
            // Befehl interpretieren.
			try {
				Befehl befehl = BefehlFactory.createBefehl(input);
				end = ausfuehrenBefehl(befehl);
			} catch (BefehlUnbekanntException e) {
				System.out.println(e.getMessage());
			}
		}

		ausgebenEndText();
	}

	private boolean ausfuehrenBefehl(Befehl befehl) {
		boolean end = false;
		switch (befehl.getBefehlswort()) {
			case "go":
				wechselBereich(befehl.getBefehlszusatz());
				break;
			case "help":
				ausgebenHilfeText();
				break;
			case "quit":
				end = true;
				break;
			default:
				ausgebenFehlerBefehl();

		}
		return end;
	}

	private void wechselBereich(String befehlszusatz) {
		// Neuen Bereich ermitteln.
		Richtungen richtung = Richtungen.valueOf(befehlszusatz.toUpperCase());
		Bereich neuerBereich = spieler.getBereich().getNachbar(richtung);
		// Auswertung der gefundenen Bereichs.
		if (neuerBereich == null) {
			System.out.println("Dort geht es nicht weiter.");
		} else {
			try {
				spieler.gehenInBereich(neuerBereich);
			} catch (SpielerZuSchwachException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(spieler.getInfo());
		}
	}

	private static void ausgebenHilfeText() {
		System.out.println("Du irrst in Nogard herum.");
		System.out.println("Dir stehen folgende Befehle zur Verf�gung:");
		System.out.println("\tgo");
		System.out.println("\tquit");
		System.out.println("\thelp");
	}

	private static void ausgebenEndText() {
		// Endbildschirm ausgeben.
		System.out.println("Danke f�r dieses Spiel. Auf Wiedersehen.");
	}

	private void ausgebenStartText() {
		// Begr��ungsbildschirm ausgeben.
		System.out.println("Willkommen in Nogard!");
		System.out.println("Entdecke die Welt von Nogard. Doch Vorsicht, �berall lauern Gefahren!");
		System.out.println("Wenn du Hilfe ben�tigst, tippe 'help'.");
		System.out.println();
		System.out.println(aktiverBereich.getInfo());
	}

	private static void ausgebenFehlerBefehl() {
		System.out.println("Ich wei� nicht, was Du meinst ...");
	}
}