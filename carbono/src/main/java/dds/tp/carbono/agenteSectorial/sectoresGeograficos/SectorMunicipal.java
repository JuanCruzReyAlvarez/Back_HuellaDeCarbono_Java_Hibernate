package dds.tp.carbono.agenteSectorial.sectoresGeograficos;

import java.util.List;


import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.services.external.dto.Municipio;
import lombok.Setter;

public class SectorMunicipal extends SectorGeografico {
    @Setter Municipio municipio;

    @Override
    public List<Organizacion> getOrganizaciones(){
        return dao.getAll().stream().filter(org -> isMunicipio(org.getUbicacion().
        getMunicipio())).toList();
    }
    private Boolean isMunicipio(Municipio municipioToCompare){
        return municipioToCompare == municipio ;
    } 
} 
