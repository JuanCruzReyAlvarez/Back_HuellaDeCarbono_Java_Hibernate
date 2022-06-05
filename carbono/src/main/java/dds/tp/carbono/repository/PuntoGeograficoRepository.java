package dds.tp.carbono.repository;

import dds.tp.carbono.entities.point.PuntoGeografico;

public class PuntoGeograficoRepository extends Repository<PuntoGeografico> {
    
    private static PuntoGeograficoRepository instance;

    public static PuntoGeograficoRepository getInstance() {
        if (instance == null)
            instance = new PuntoGeograficoRepository();

        return instance;
    }

    @Override
    public PuntoGeografico setId(Integer id, PuntoGeografico item) {
        item.setId(id);
        return item;
    }
}
