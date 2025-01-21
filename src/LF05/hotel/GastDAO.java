package LF05.hotel;

import LF05.hotel.exceptions.GastNichtVorhandenException;
import LF05.hotel.exceptions.GastSchonVorhandenException;
import LF05.hotel.interfaces.GastMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GastDAO implements GastMap {

    private Map<Integer, Gast> guests = new HashMap<>();

    @Override
    public void insert(Gast gast) throws GastSchonVorhandenException {
        if ( !guests.containsKey(gast.getGastNr()) ) {
            guests.put(gast.getGastNr(), gast);
        } else {
            throw new GastSchonVorhandenException(gast);
        }
    }

    @Override
    public void update(Gast gast) throws GastNichtVorhandenException {
        if ( guests.containsKey(gast.getGastNr()) ) {
            guests.put(gast.getGastNr(), gast);
        } else {
            throw new GastNichtVorhandenException(gast.getGastNr());
        }
    }

    @Override
    public void delete(Integer key) throws GastNichtVorhandenException{
        if ( guests.containsKey(key) ) {
            guests.remove(key);
        } else {
            throw new GastNichtVorhandenException(key);
        }
    }

    @Override
    public Gast getById(Integer key) throws GastNichtVorhandenException{
        if ( guests.containsKey(key) ) {
            return guests.get(key);
        }
        throw new GastNichtVorhandenException(key);
    }

    @Override
    public List<Gast> getAll() {
        return guests.values().stream().toList();
    }
}
