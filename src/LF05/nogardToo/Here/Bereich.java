package LF05.nogardToo.Here;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse modelliert Bereiche. Ein Bereich kann ein Gebiet, ein Haus, ein Raum etc. sein.
 * 
 * Jeder Bereich ist mit anderen Bereichen �ber Ausg�nge verbunden. M�gliche Ausg�nge liegen im Norden, Osten, S�den, Westen, oben und unten.
 * 
 * F�r jeden Ausgang h�lt ein Bereich eine Referenz auf den benachbarten Bereich parat.
 */
public class Bereich {
	
    private String beschreibung;
    private Map<Richtungen, Bereich> nachbarn;
    private List<Gegenstand> gegenstaende; 

    /**
     * Konstruktor.
     * @param beschreibung	Die Beschreibung des Areals.
     */
    public Bereich(String beschreibung) {
        this.beschreibung = beschreibung;
        nachbarn = new HashMap<>();
        for (Richtungen richtung : Richtungen.values()) {
			nachbarn.put(richtung, null);
		}
        gegenstaende = new LinkedList<>();
    }

    /**
     * Liefert die Beschreibung des Bereichs.
     * @return	Die Beschreibung des Bereichs.
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Liefert einen benachbarten Bereich.
     * @param richtung	Die Richtung des gew�nschten benachbarten Bereichs.
     * @return			Der gew�nschte benachbarte Bereich.
     */
    public Bereich getNachbar(Richtungen richtung) {
    	return nachbarn.get(richtung);
    }
	
	/**
	 * Gibt die Informationen �ber den Bereich zur�ck.
	 * @return	Die Informationen �ber den Bereich.
	 */
	public String getInfo() {
		StringBuilder info = new StringBuilder();
		info.append("\nDu befindest dich " + beschreibung + ".");
		// Alle gegenst�nde ausgeben, wenn vorhanden.
		if (gegenstaende.size() > 0) {
			info.append("\nHier befinden sich die folgenden Gegenst�nde:");
			for (Gegenstand gegenstand : gegenstaende) {
				info.append("\n\t" + gegenstand.getInfo());
			}
		}
        info.append("\nDu kannst gehen nach:");
        // Alle nichtleeren Bereiche ausgeben.
        for (Map.Entry<Richtungen, Bereich> paar : nachbarn.entrySet()) {
			if (paar.getValue() != null) {
				info.append("\n\t" + paar.getKey().name().toLowerCase());
			}
		}
        return info.toString();
	}
    
    /**
     * F�gt einen benachbarten Bereich hinzu.
     * Befindet sich bereits ein benachbarter Bereich an dieser Stelle, so wird er durch den neuen ersetzt.
     * @param richtung	Die Richtung, in der sich der hinzuzuf�gende benachbarte Bereich befindet.
     * @param nachbar	Der hinzuzuf�gende benachbarte Bereich.
     */
    public void setNachbar(Richtungen richtung, Bereich nachbar) {
    	nachbarn.put(richtung, nachbar);
    }

    /**
     * F�gt einen neuen Gegenstand dem Bereich hinzu.
     * @param gegenstand	Der hinzuzuf�gende Gegenstand.
     */
	public void platzierenGegenstand(Gegenstand gegenstand) {
		gegenstaende.add(gegenstand);
	}
	
	/**
	 * Entfernt einen Gegenstand aus dem Bereich.
	 * @param nameGegenstand	Der zu entfernende Gegenstand.
	 * @throws GegenstandNichtVorhandenException	Wird geworfen, wenn der zu entfernende Gegenstand nicht vorhanden ist.
	 */
	public void entfernenGegenstand(Gegenstand gegenstand) throws GegenstandNichtVorhandenException {
		boolean entfernt = gegenstaende.remove(gegenstand);
		if (entfernt == false) {
			throw new GegenstandNichtVorhandenException("In diesem Bereich befindet sich leider kein Gegenstand mit dem Namen " + gegenstand.getName() + ".");
		}
	}
	
	/**
	 * Sucht einen Gegenstand im Bereich.
	 * @param nameGegenstand	Der Name des zu suchenden Gegenstandes.
	 * @return					Der gesuchte Gegenstand.
	 * @throws GegenstandNichtVorhandenException	Wird geworfen, wenn kein Gegenstand im Bereich den angegebenen Namen hat.
	 */
	public Gegenstand suchenGegenstand(String nameGegenstand) throws GegenstandNichtVorhandenException {
		for (Gegenstand gegenstand : gegenstaende) {
			if(gegenstand.getName().equalsIgnoreCase(nameGegenstand)) {
				return gegenstand;
			}
		}
		throw new GegenstandNichtVorhandenException("In diesem Bereich befindet sich leider kein Gegenstand mit dem Namen " + nameGegenstand + ".");
	}

}
