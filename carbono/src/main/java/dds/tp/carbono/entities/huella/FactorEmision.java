package dds.tp.carbono.entities.huella;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="FactorEmision")
public class FactorEmision {
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private TipoDeConsumo tipoDeConsumo;

    @Enumerated(EnumType.STRING)
    @Getter @Setter private TipoActividad tipoActividad;
    
    @Column
    @Getter @Setter private Double valor;
    
    @Enumerated(EnumType.STRING)
    @Getter @Setter private UnidadFE unidad;

    public FactorEmision() {
        this.valor = 0.0;    
    }

    public FactorEmision(TipoDeConsumo tipoDeConsumo, TipoActividad tipoActividad, Double valor, UnidadFE unidad) {
        this.tipoDeConsumo = tipoDeConsumo;
        this.tipoActividad = tipoActividad;
        this.valor = valor;
        this.unidad = unidad;
    }
}
