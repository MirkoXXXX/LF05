package LF05.nogardToo.Here;

/**
 * Modelliert den Befehl "eat" zum Verzehr von Nahrung.
 */
public class CommandEat implements ICommand {

	private Spieler spieler;
	private String nahrung;
	
	/**
	 * Konstruktor.
	 * @param spieler	Der Spieler, der essen soll.
	 * @param nahrung	Die Nahrung, die der Spieler verzehren soll.
	 */
	public CommandEat(Spieler spieler, String nahrung) {
		this.spieler = spieler;
		this.nahrung = nahrung;
	}

	/* (non-Javadoc)
	 * @see LF05.nogardToo.Here.ICommand#execute()
	 */
	@Override
	public void execute() {
		try {
			spieler.essen(nahrung);
			System.out.println(spieler.getInfo());
		} catch (GegenstandNichtVorhandenException | SpielerSattException e) {
			System.out.println(e.getMessage());
		}
	}

}
