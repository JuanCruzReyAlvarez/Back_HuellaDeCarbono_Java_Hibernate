package dds.tp.carbono.entities.huella;

import lombok.Getter;
import lombok.Setter;

public class HuellaCarbono {
    @Getter @Setter private Double valor;
    @Getter @Setter private UnidadHC unidad;

    public  HuellaCarbono (){
        this.valor = 0.00;
        this.unidad = UnidadHC.gCO2eq;
    }
    public HuellaCarbono suma(HuellaCarbono huella){
        return new HuellaCarbono();
    }

}
