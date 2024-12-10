package LF05.fussball;

import java.util.ArrayList;
public class Mannschaft {

    private String name;
    private Trainer trainer;
    private Torwart torwart;
    private ArrayList<Spieler> playerList = new ArrayList<Spieler>();

    public Mannschaft (String name, Trainer trainer, Torwart torwart, ArrayList<Spieler> playerList) {
        this.name = name;
        this.trainer = trainer;
        this.torwart = torwart;
        this.playerList = playerList;
    }

    public ArrayList<Spieler> getPlayerList() {
        return playerList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public Torwart getTorwart() {
        return torwart;
    }

    public void setTorwart(Torwart torwart) {
        this.torwart = torwart;
    }

    @Deprecated
    public void addPlayer(Spieler player) {
        if (playerList.contains(player)) { return; }
        playerList.add(player);
    }

    public void removePlayer(Spieler player) {
        playerList.remove(player);
    }

    public int getMotivation() {
        int sum = torwart.getMotivation();
        for (Spieler p : playerList) {
            sum += p.getMotivation();
        }
        sum += (getTrainer().getErfahrung()/2);
        return sum / (playerList.size()+1);
    }

    public int getStrength() {
        int sum = torwart.getStrength();
        for (Spieler p : playerList) {
            sum += p.getStrength();
        }
        return sum / (playerList.size()+1);
    }
}