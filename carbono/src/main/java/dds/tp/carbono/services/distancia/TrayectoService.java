package dds.tp.carbono.services.distancia;


import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.repository.member.TrayectoRepository;

public class TrayectoService {

    private TrayectoRepository repository;

    public TrayectoService() {
        this.repository = new TrayectoRepository();
    }

    public Trayecto crear(Trayecto organizacion) throws Exception {

        if (!organizacion.isValid())
            throw new Exception("Invalid Organization");

        return this.repository.guardar(organizacion);         
    }
    /*
    public Trayecto getByUser(Trayecto user) {
        return this.repository.getByUser(user);
    }

     
    public Trayecto getByRazonSocial(String razonSocial ) {
        return this.repository.getByRazonSocial(razonSocial);
    }

    public List<Trayecto> getBy(Municipio municipio) {
        return this.repository.getBy(municipio);
    }

    public List<Trayecto> getBy(Provincia provincia) {
        return this.repository.getBy(provincia);
    }

    public List<Trayecto> getAll() {
        return this.repository.getAll();
    }
   */
    
}
