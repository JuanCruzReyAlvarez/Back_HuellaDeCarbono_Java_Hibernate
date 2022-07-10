package dds.tp.carbono.agenteSectorial.sectoresGeograficos;

import java.util.List;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.services.external.dto.Provincia;
import lombok.Setter;

public class SectorProvincial extends SectorGeografico{
    @Setter Provincia provincia;

    @Override
    public List<Organizacion> getOrganizaciones(){
        return dao.getAll().stream().filter(org -> isProvincia(org.getUbicacion().
        getMunicipio().getProvincia())).toList();
    }

    private Boolean isProvincia(Provincia provinciaToCompare){
        return provinciaToCompare == provincia ;
    } 
}