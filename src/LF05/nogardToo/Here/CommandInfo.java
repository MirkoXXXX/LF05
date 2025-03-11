package LF05.nogardToo.Here;

/**
 * Modelliert den Befehl "info" zur Ausgabe der Spielerinfo.
 */
public class CommandInfo implements ICommand {

	private Spieler spieler;
	
	/**
	 * Konstruktor.
	 * @param spieler	Der Spieler, dessen Spielerinfo ausgegeben werden soll. 
	 */
	public CommandInfo(Spieler spieler) {
		this.spieler = spieler;
	}

	/* (non-Javadoc)
	 * @see LF05.nogardToo.Here.ICommand#execute()
	 */
	@Override
	public void execute() {
		System.out.println(spieler.getInfo());	
	}

}
