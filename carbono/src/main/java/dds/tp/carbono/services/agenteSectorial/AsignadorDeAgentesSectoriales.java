package dds.tp.carbono.services.agenteSectorial;

import java.util.List;

import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;
import dds.tp.carbono.entities.agenteSectorial.SectorProvincial;
import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import dds.tp.carbono.services.organizacion.OrganizacionService;

public class AsignadorDeAgentesSectoriales {

    private SectorTerritorialRepository repo;

    public AsignadorDeAgentesSectoriales() {
        this.repo = new SectorTerritorialRepository();
    }
   
    public SectorTerritorial asignar(Municipio municipio, Usuario usuario) throws Exception {
        SectorTerritorial sector = repo.getBy(usuario);

        if (sector == null) {
            SectorMunicipal sm = new SectorMunicipal();
            sm.setMunicipio(municipio);
            sm.setUsuario(usuario);
            sm.setOrganizaciones(this.asignarOrganiacionesMunicipio(municipio));
    
            return this.repo.guardar(sm);
        }

        throw new Exception("Agente sectorial ya tenia asgnado sector territorial");
    }

    public SectorTerritorial asignar(Provincia provincia, Usuario usuario) throws Exception {

        SectorTerritorial sector = repo.getBy(usuario);

        if (sector == null) {
            SectorProvincial sm = new SectorProvincial();
            sm.setProvincia(provincia);
            sm.setUsuario(usuario);
            sm.setOrganizaciones(this.asignarOrganiacionesProvincia(provincia));

            return this.repo.guardar(sm);
        }

        throw new Exception("Agente sectorial ya tenia asgnado sector territorial");
    }

    private List<Organizacion> asignarOrganiacionesMunicipio(Municipio municipio){ 
        return new OrganizacionService().getBy(municipio);  
    }

    private List<Organizacion> asignarOrganiacionesProvincia(Provincia provincia){
        return new OrganizacionService().getBy(provincia); 
    }
}
