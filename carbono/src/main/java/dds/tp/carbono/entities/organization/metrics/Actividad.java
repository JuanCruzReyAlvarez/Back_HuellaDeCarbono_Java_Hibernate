package dds.tp.carbono.entities.organization.metrics;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="actividad")
public abstract class Actividad {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Enumerated(EnumType.STRING)
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