package LF05.fussball;

import java.util.ArrayList;
import java.util.Random;
import static util.IO.log;

public class Tests {
    public static void main(String[] args) {

        ArrayList<Spieler> pl1 = new ArrayList<>();
        ArrayList<Spieler> pl2 = new ArrayList<>();
        Random rnd = new Random();

        pl1.add(new Spieler("Duck Donaldo",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Robert Lewandowski",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Lionel Messi",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Mohamed Salah",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Karim Benzema",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Jorginho",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Kylian Mbapp�",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Erling Haaland",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Cristiano Ronaldo",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("N'Golo Kant�",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl1.add(new Spieler("Kevin De Bruyne",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));

        pl2.add(new Spieler("Romelu Lukaku",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Gianluigi Donnarumma",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Neymar",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("R�ben Dias",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Harry Kane",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Bruno Fernandes",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Federico Chiesa",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Joshua Kimmich",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Luis Su�rez",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("�douard Mendy",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));
        pl2.add(new Spieler("Pedri",rnd.nextInt(18,37),rnd.nextInt(1,11),rnd.nextInt(1,11),rnd.nextInt(1,11)));

        Spiel game = new Spiel(
                new Mannschaft("FC Heim",
                        new Trainer("Merciado",55,9),
                        new Torwart("Neuer",32,8,9,7),pl1),
                new Mannschaft("FC Gast",
                        new Trainer("Bancini",67,10),
                        new Torwart("TerStegen",29,7,10,6),pl2));


        try {
            Gameplay.doGame(game);
        } catch (GameBreakException e) {
            log(e.getMessage());
            log("Vorl�ufiges Ergebnis: "+game.getErgebnis().toString());
        }
        log(game.toString());
    }
}