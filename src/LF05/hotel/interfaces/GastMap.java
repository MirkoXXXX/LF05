package LF05.hotel.interfaces;

import LF05.hotel.Gast;
import LF05.hotel.exceptions.GastSchonVorhandenException;
import LF05.hotel.exceptions.GastNichtVorhandenException;

import java.util.List;

public interface GastMap {

    void insert(Gast gast) throws GastSchonVorhandenException;

    Gast getById(Integer nr) throws GastNichtVorhandenException;

    List<Gast> getAll();

    void update(Gast gast) throws GastNichtVorhandenException;

    void delete(Integer nr) throws GastNichtVorhandenException;
}
