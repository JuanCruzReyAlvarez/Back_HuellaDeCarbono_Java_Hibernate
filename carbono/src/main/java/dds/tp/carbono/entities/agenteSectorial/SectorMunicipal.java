package dds.tp.carbono.entities.agenteSectorial;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import dds.tp.carbono.services.external.dto.Municipio;
import dds.tp.carbono.services.external.dto.Provincia;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("municipio")
public class SectorMunicipal extends SectorTerritorial{
    @OneToOne
    @Setter @Getter Municipio municipio;

    public Provincia getProvincia(){
        return municipio.getProvincia();
    }
}
