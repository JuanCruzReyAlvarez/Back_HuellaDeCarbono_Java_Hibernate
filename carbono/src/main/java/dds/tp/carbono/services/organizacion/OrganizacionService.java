package dds.tp.carbono.services.organizacion;

import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;


// Es un service no pertenece a dominio no hay drama con el repository

public class OrganizacionService {

    private OrganizacionRepository repository;

    public OrganizacionService() {
        this.repository = new OrganizacionRepository();
    }

    public Organizacion crear(Organizacion organizacion) throws Exception {

        if (!organizacion.isValid())
            throw new Exception("Invalid Organization");

        return this.repository.guardar(organizacion);         
    }

    public Organizacion getByUser(Integer id) {
        return this.repository.getByUser(id);
    }
    public Organizacion getById(Integer id) {
        return this.repository.getById(id);
    }

    public Organizacion getByRazonSocial(String razonSocial ) {
        return this.repository.getByRazonSocial(razonSocial);
    }

    public List<Organizacion> getBy(Municipio municipio) {
        return this.repository.getBy(municipio);
    }

    public List<Organizacion> getBy(Provincia provincia) {
        return this.repository.getBy(provincia);
    }

    public List<Organizacion> getAll() {
        return this.repository.getAll();
    }
   


}