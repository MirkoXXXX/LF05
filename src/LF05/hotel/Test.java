package LF05.hotel;

import LF05.hotel.exceptions.GastNichtVorhandenException;
import LF05.hotel.exceptions.GastSchonVorhandenException;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Adresse adresse1 = new Adresse("Galaxieweg", "28", "25567", "Bielefeld");
        Adresse adresse2 = new Adresse("Turnstrasse", "77", "27666", "Tuerkei");

        List<Zimmer> zlist = new ArrayList<>();
        for ( int i = 1; i <= 50; i++ ) {
            zlist.add(new Zimmer(i));
        }

        Etage etage1 = new Etage("Kamel");
        Etage etage2 = new Etage("Andromeda");

        for (Zimmer zimmer : zlist) {
            etage1.getZimmerListe().add(zimmer);
        }

        Gebaeude gebaeude1 = new Gebaeude("Sirius");

        gebaeude1.getEtagenListen().add(etage1);
        gebaeude1.getEtagenListen().add(etage2);

        Hotelanlage hotelanlage = new Hotelanlage(adresse1);

        Gast gast = new Gast(14, adresse2, "Guenther", "Hermann");

        try {
            hotelanlage.einchecken(gast, 18);
            hotelanlage.auschecken(gast.getGastNr(), 18);
        } catch (GastSchonVorhandenException | GastNichtVorhandenException e) {
            System.out.println(e.getMessage());
        }
    }
}
