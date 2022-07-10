package dds.tp.carbono.entities.organization.metrics;
import lombok.Getter;
import lombok.Setter;

public abstract class Actividad {

    @Setter @Getter protected TipoActividad tipoActividad;

    public DatoActividad getDatoActividad() {

        DatoActividad datoActividad = new DatoActividad();
        datoActividad.setValor(this.getValorDA());
        datoActividad.setUnidad(this.getUnidadDA());
        
        return datoActividad;
    }

    public abstract TipoDeConsumo getTipoDeConsumo();
    protected abstract Double getValorDA();
    protected abstract Unidad getUnidadDA();
}