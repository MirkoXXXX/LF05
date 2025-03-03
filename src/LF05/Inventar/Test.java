package LF05.Inventar;

import static util.IO.log;

public class Test {
    public static void main(String[] args) {

        //This is not a complete test
        Room room = new Room(0);

        Tisch tisch1 = new Tisch(0,"kbuvdf");
        Tisch tisch2 = new Tisch(1,"sfsdf");
        Tisch tisch3 = new Tisch(2,"sdfsdf");

        tisch1.setBreite(11);
        tisch1.setHoehe(22);
        tisch1.setLaenge(33);
        tisch1.setWeight(13);

        tisch2.setBreite(7);
        tisch2.setHoehe(8);
        tisch2.setLaenge(9);
        tisch2.setWeight(10);


        tisch3.setBreite(13);
        tisch3.setHoehe(14);
        tisch3.setLaenge(15);
        tisch3.setWeight(5);

        //Exception Test
        //room.removeMoebel(6);

        room.addMoebel(tisch1);
        room.addMoebel(tisch2);
        room.addMoebel(tisch3);


    }
}
