package dds.tp.carbono.entities.agenteSectorial;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;


import dds.tp.carbono.services.external.dto.Provincia;
import lombok.Setter;
@Entity
@DiscriminatorValue("provincia")
public class SectorProvincial extends SectorTerritorial {
    @OneToOne
    @Setter Provincia provincia;

    public SectorProvincial(){
    
    }

}
