package dds.tp.carbono.entities.organization.metrics;

import dds.tp.carbono.entities.organization.metrics.logistica.CategoriaLogistica;
import dds.tp.carbono.entities.organization.metrics.logistica.TransporteLogistica;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



@Entity
@DiscriminatorValue("logisticaDeProductosServicios")
public class LogisticaDeProductosServicios extends Actividad {

    @Column
    private static final double FACTOR_K = 1;
    
    @Column
    @Setter @Getter private Double distancia;
    
    @Column
    @Setter @Getter private Double peso; 

    @Enumerated(EnumType.STRING)
    @Setter @Getter private CategoriaLogistica categoria; 

    @Enumerated(EnumType.STRING)
    @Setter @Getter private TransporteLogistica transporte; 

    @Enumerated(EnumType.STRING)
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