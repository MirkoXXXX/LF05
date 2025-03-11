package LF05.nogardToo.Here;

/**
 * Modelliert den Befehl "go" zum Wechseln eines Bereichs.
 */
public class CommandGo implements ICommand {

	private Spieler spieler;
	private Richtungen richtung;
	
	/**
	 * Konstruktor.
	 * @param spieler	Der Spieler, der den Bereich wechseln soll.
	 * @param richtung	Die Richtung, in die der Spieler gehen soll.
	 */
	public CommandGo(Spieler spieler, Richtungen richtung) {
		this.spieler = spieler;
		this.richtung = richtung;
	}

	/* (non-Javadoc)
	 * @see LF05.nogardToo.Here.ICommand#execute()
	 */
	@Override
	public void execute() {
		Bereich neuerBereich = spieler.getBereich().getNachbar(richtung);
		// Auswertung der gefundenen Bereichs.
		if (neuerBereich == null) {
			System.out.println("Dort geht es nicht weiter.");
		} else {
			try {
				spieler.gehenInBereich(neuerBereich);
				System.out.println(spieler.getInfo());
			} catch (SpielerZuSchwachException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
