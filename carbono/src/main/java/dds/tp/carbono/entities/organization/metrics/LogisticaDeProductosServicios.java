package dds.tp.carbono.entities.organization.metrics;

import lombok.Getter;
import lombok.Setter;

public class LogisticaDeProductosServicios extends Actividad{

    @Setter @Getter private Double distancia;
    @Setter @Getter private Peso peso; 


    @Override
    public DatoActividad getDatoActividad() {
        
        DatoActividad datoActividad = new DatoActividad();

        datoActividad.setUnidad(this.consumo.getUnidad());
        datoActividad.setValor(this.obtenerValorActividad());
        
        return super.getDatoActividad();
    }

    private Double obtenerValorActividad() {
        return getDistancia().doubleValue()
                *getPeso().getValor().doubleValue()
                *getK().doubleValue();
    }

    private Double getK(){
        return (double) 1;
    }

   
    
}
