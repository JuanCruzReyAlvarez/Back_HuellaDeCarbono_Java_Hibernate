package dds.tp.carbono.agenteSectorial.agente;

import org.apache.commons.math3.stat.descriptive.summary.Sum;

import dds.tp.carbono.agenteSectorial.sectoresGeograficos.SectorGeografico;
import lombok.Setter;
import lombok.Getter;

public class AgenteSectorial{

@Getter @Setter private Integer id;
@Getter SectorGeografico sectorGeografico;

public Boolean isValid() {  
    return new AgenteSectorialValidator().validate(this);
}

/*
public Double calcularHuellaSector(){
    return  (double) sectorGeografico.getOrganizaciones().stream().
            mapToDouble(org-> org.calcularHC()).sum();
     aca sumo cada huella de carbono.
}
 */
}