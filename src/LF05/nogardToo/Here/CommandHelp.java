package LF05.nogardToo.Here;

/**
 * Modelliert den Befehl "help" zur Ausgabe eines Hilfetextes.
 */
public class CommandHelp implements ICommand {

	/* (non-Javadoc)
	 * @see LF05.nogardToo.Here.ICommand#execute()
	 */
	@Override
	public void execute() {
		System.out.println("Du irrst in Nogard herum.");
		System.out.println("Dir stehen folgende Befehle zur Verf�gung:");
		System.out.println("\teat\tVerzehr einer Nahrung");
		System.out.println("\tgo\tWechseln des Bereichs");
		System.out.println("\thelp\tAuflistung aller m�glichen Befehle");
		System.out.println("\tinfo\tInformationen zur Spielfigur");
		System.out.println("\ttake\tAufnehmen eines Gegenstandes");
		System.out.println("\tput\tAblegen eines Gegenstandes");
		System.out.println("\tquit\tBeenden des Spiels");
	}

}
