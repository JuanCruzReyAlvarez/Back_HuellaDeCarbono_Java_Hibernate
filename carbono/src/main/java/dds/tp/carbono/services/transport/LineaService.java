package dds.tp.carbono.services.transport;

import java.util.List;

import dds.tp.carbono.entities.transport.Linea;
import dds.tp.carbono.repository.admin.LineaRepository;

public class LineaService {
    private LineaRepository repository;

    public LineaService() {
        this.repository = new LineaRepository();
    }

    public List<Linea> getAllLineas(){
        return repository.getAll();
    }
}








