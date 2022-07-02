package dds.tp.carbono.entities.organization.metrics;
import lombok.Getter;
import lombok.Setter;

public abstract class Actividad {
    @Setter @Getter public Consumo consumo;

    public DatoActividad getDatoActividad(){

        DatoActividad datoActividad = new DatoActividad();

        datoActividad.setValor(this.consumo.getValor());
        datoActividad.setUnidad(this.consumo.getUnidad());
        
        return datoActividad ;
    }
}
