package dds.tp.carbono.dao.member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;

public class TrayectoDao extends Dao<Trayecto> {
    
    private static TrayectoDao instance;

    public static TrayectoDao getInstance() {
        if (instance == null)
            instance = new TrayectoDao();

        return instance;
    }

    public List<Tramo> getTramos() {
        List<Tramo> listaTramos = new ArrayList<Tramo>();

        this.getAll()
            .stream()
            .map(t -> t.getTramos())
            .collect(Collectors.toList())
            .forEach(lt -> lt.forEach(t -> listaTramos.add(t)));

        return listaTramos;
    }

    @Override
    public Trayecto setId(Integer id, Trayecto item) {
        item.setId(id);
        return item;
    }
}