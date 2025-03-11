package LF05.nogardToo.Here;

/**
 * Modelliert den Befehl "quit" zur Ausgabe eines Hilfetextes.
 */
public class CommandQuit implements ICommand {

	/* (non-Javadoc)
	 * @see LF05.nogardToo.Here.ICommand#execute()
	 */
	@Override
	public void execute() {
		System.out.println("Danke f�r dieses Spiel. Auf Wiedersehen.");
	}

}
