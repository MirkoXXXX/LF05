package LF05.nogardToo.Here;

/**
 * Modelliert den Befehl "take" zum Aufnehmen eines Gegenstandes.
 */
public class CommandTake implements ICommand {

	private Spieler spieler;
	private String gegenstand;
	
	/**
	 * Konstruktor.
	 * @param spieler		Der Spieler, der einen Gegenstand aufnehmen soll.
	 * @param gegenstand	Der Gegenstand, den der Spieler aufnehmen soll.
	 */
	public CommandTake(Spieler spieler, String gegenstand) {
		this.spieler = spieler;
		this.gegenstand = gegenstand;
	}

	/* (non-Javadoc)
	 * @see LF05.nogardToo.Here.ICommand#execute()
	 */
	@Override
	public void execute() {
		try {
			spieler.aufnehmenGegenstand(gegenstand);
			System.out.println(spieler.getInfo());
		} catch (GegenstandNichtVorhandenException | GegenstandZuSchwerException e) {
			System.out.println(e.getMessage());
		}
	}

}
