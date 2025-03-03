package LF05.Inventar;

import java.util.ArrayList;

public class Room {
    private int roomId;
    private Techniker techniker;
    private ArrayList<Moebelstueck> moebelListe = new ArrayList<Moebelstueck>();

    public Room(int roomId) {
        this.roomId = roomId;
    }

    public ArrayList<Moebelstueck> getMoebelListe() {
        return moebelListe;
    }

    public void addMoebel(Moebelstueck moebel){
        moebelListe.add(moebel);
    }

    public Moebelstueck getMoebel(int id) throws MoebelNichtGefundenEcxeption{
        if(!moebelListe.contains(id)){
            throw new MoebelNichtGefundenEcxeption(id);
        }
        return moebelListe.get(id);
    }

    public void removeMoebel(int id) throws MoebelNichtGefundenEcxeption{
        if(!moebelListe.contains(id)){
            throw new MoebelNichtGefundenEcxeption(id);
        }
        moebelListe.remove(id);
    }

    public int getAnzahlmoebel(){
        return moebelListe.size();
    }

    public double getGewichtGesamt(){
        return moebelListe.stream().mapToDouble(Moebelstueck::getWeight).sum();
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", techniker=" + techniker +
                ", moebelListe=" + moebelListe +
                '}';
    }
}
