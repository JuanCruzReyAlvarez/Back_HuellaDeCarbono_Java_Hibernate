package dds.tp.carbono.entities.organization.metrics;

import dds.tp.carbono.entities.organization.metrics.logistica.CategoriaLogistica;
import dds.tp.carbono.entities.organization.metrics.logistica.TransporteLogistica;
import lombok.Getter;
import lombok.Setter;

public class LogisticaDeProductosServicios extends Actividad {

    private static final double FACTOR_K = 1;
    
    @Setter @Getter private Double distancia;
    @Setter @Getter private Double peso; 
    @Setter @Getter private CategoriaLogistica categoria; 
    @Setter @Getter private TransporteLogistica transporte; 

    @Setter @Getter private TipoDeConsumo tipoDeConsumo; 

    public LogisticaDeProductosServicios() {
        this.tipoActividad = TipoActividad.Logistica_De_Productos_Servicios;
    }

    @Override
    protected Double getValorDA() {
        return this.distancia * this.peso * FACTOR_K;
    }

    @Override
    protected Unidad getUnidadDA() {
        return Unidad.KM;
    }
}