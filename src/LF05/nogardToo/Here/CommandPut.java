package LF05.nogardToo.Here;

/**
 * Modelliert den Befehl "put" zum Ablegen eines Gegenstandes.
 */
public class CommandPut implements ICommand {

	private Spieler spieler;
	private String gegenstand;
	
	/**
	 * Konstruktor.
	 * @param spieler		Der Spieler, der einen Gegenstand ablegen soll.
	 * @param gegenstand	Der Gegenstand, den der Spieler ablegen soll.
	 */
	public CommandPut(Spieler spieler, String gegenstand) {
		this.spieler = spieler;
		this.gegenstand = gegenstand;
	}

	/* (non-Javadoc)
	 * @see LF05.nogardToo.Here.ICommand#execute()
	 */
	@Override
	public void execute() {
		try {
			spieler.ablegenGegenstand(gegenstand);
			System.out.println(spieler.getInfo());
		} catch (GegenstandNichtVorhandenException e) {
			System.out.println(e.getMessage());
		}
	}

}
