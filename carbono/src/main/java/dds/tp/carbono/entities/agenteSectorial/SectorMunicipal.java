package dds.tp.carbono.entities.agenteSectorial;

import java.util.List;

import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.organizacion.OrganizacionService;
import lombok.Getter;
import lombok.Setter;

public class SectorMunicipal extends SectorTerritorial {

    @Getter @Setter Integer id; 
    @Setter Municipio municipio;

    @Override
    public List<Organizacion> getOrganizaciones() {
        return new OrganizacionService().getBy(this.municipio);
    } 
} 
