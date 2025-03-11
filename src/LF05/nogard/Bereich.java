package LF05.nogard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse modelliert Bereiche.Ein Bereich kann ein Gebiet, ein Haus, ein Raum etc. sein.
 * 
 * Jeder Bereich ist mit anderen Bereichen �ber Ausg�nge verbunden. M�gliche Ausg�nge liegen im Norden, Osten, S�den und Westen.
 * 
 * F�r jeden Ausgang h�lt ein Bereich eine Referenz auf den benachbarten Bereich parat.
 */
public class Bereich {

	private String beschreibung;
	private Map<Richtungen, Bereich> nachbarn = new HashMap<>();

	private List<Gegenstand> gegenstaende = new LinkedList<>();

    /**
     * Konstruktor.
     * @param beschreibung	Die Beschreibung des Areals.
     */
    public Bereich(String beschreibung) {
        this.beschreibung = beschreibung;
        for (Richtungen richtung : Richtungen.values()){
			nachbarn.put(richtung, null);
		}
    }

	public void platzierenGegenstand(Gegenstand g) {
		gegenstaende.add(g);
	}

	public void entfernenGegenstand(Gegenstand g) throws GegenstandNichtVorhandenException {
		if (!gegenstaende.remove(g)) {
			throw new GegenstandNichtVorhandenException("Gegenstand: " + g.getName() + " nicht vorhanden im Bereich!");
		}
	}

	public Gegenstand suchenGegenstand(String n) throws GegenstandNichtVorhandenException {
		for (Gegenstand g : gegenstaende) {
			if (g.getName().equalsIgnoreCase(n)) {
				return g;
			}
		}
		throw new GegenstandNichtVorhandenException("Gegenstand: " + n + " nicht vorhanden!");
	}

    /**
     * Liefert die Beschreibung des Bereichs.
     * @return	Die Beschreibung des Bereichs.
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    public void setNachbarn(Richtungen richtung, Bereich nachbar) {
        nachbarn.put(richtung, nachbar);
    }

	/**
	 * Liefert den im Norden benachbarten Bereich.
	 * @return Den im Norden benachbarten Bereich.
	 */
	public Bereich getNachbar(Richtungen richtung){
		return nachbarn.get(richtung);
	}

	public List<Gegenstand> getGegenstaende() {
		return gegenstaende;
	}

	public String getInfo(){
		StringBuilder sb = new StringBuilder();
		sb.append("Du befindest dich ").append(this.getBeschreibung()).append(".");
		sb.append("\nDeine Gegenstaende sind:");
		for (Gegenstand g : gegenstaende) {
            sb.append("\n\t").append(g.getName()).append(" - ").append(g.getBeschreibung());
        }
		sb.append("\nDu kannst gehen nach:");
		for (Map.Entry<Richtungen, Bereich> paar : nachbarn.entrySet()) {
			if(paar.getValue() != null) {
				sb.append("\n\t").append(paar.getKey().name().toLowerCase());
			}
		}
		// Der fertige String
		String result = sb.toString();
		return result;
	}


}
