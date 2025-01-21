package LF05.hotel;

import LF05.hotel.exceptions.GastNichtVorhandenException;
import LF05.hotel.exceptions.GastSchonVorhandenException;

import java.util.ArrayList;
import java.util.List;

public class Hotelanlage extends GastDAO{
    private Adresse adresse;

    private List<Gebaeude> gebaeudeList = new ArrayList<>();
    public Hotelanlage (Adresse adresse) {
        this.adresse = adresse;
    }

    public void auschecken(Integer GastNr, Integer ZimmerNr) throws GastNichtVorhandenException {
        delete(GastNr);
        getZimmer(ZimmerNr).checkOut(getById(GastNr));
    }

    public void einchecken(Gast gast, Integer ZimmerNr) throws GastSchonVorhandenException {
        insert(gast);
        getZimmer(ZimmerNr).checkIn(gast);
    }

    public void addGebaeude(Gebaeude gebaeude) {
        this.gebaeudeList.add(gebaeude);
    }

    public void removeGebaeude(Gebaeude gebaeude) {
        this.gebaeudeList.remove(gebaeude);
    }

    private Zimmer getZimmer(int nr) {
        for ( Gebaeude gebaeude : gebaeudeList) {
            for ( Etage etage : gebaeude.getEtagenListen() ) {
                for ( Zimmer zimmer : etage.getZimmerListe() ) {
                    if ( zimmer.getNr() == nr ) {
                        return zimmer;
                    }
                }
            }
        }
        return null;
    }
}
