package dds.tp.carbono.entities.organization.metrics;


import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="actividad")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name= "tipoDeActividad")
public abstract class Actividad {

    @Id
    @GeneratedValue
    @Getter @Setter Integer id;

    @Transient
    @Setter @Getter protected TipoActividad tipoActividad;

    public DatoActividad getDatoActividad() {

        DatoActividad datoActividad = new DatoActividad();
        datoActividad.setValor(this.getValorDA());
        datoActividad.setUnidad(this.getUnidadDA());
        datoActividad.setActividad(this);
        
        return datoActividad;
    }

    public abstract TipoDeConsumo getTipoDeConsumo();
    protected abstract Double getValorDA();
    protected abstract Unidad getUnidadDA();
}       