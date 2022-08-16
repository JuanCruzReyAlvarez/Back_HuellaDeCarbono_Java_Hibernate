package dds.tp.carbono.entities.agenteSectorial;


import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import lombok.Getter;
import lombok.Setter;

public class SectorMunicipal extends SectorTerritorial{
    @Setter @Getter Municipio municipio;

    public Provincia getProvincia(){
        return municipio.getProvincia();
    }
}
