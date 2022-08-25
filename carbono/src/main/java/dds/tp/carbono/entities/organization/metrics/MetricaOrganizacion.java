package dds.tp.carbono.entities.organization.metrics;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name= "metricaOrganizacion")
public class MetricaOrganizacion {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @OneToOne
    @Setter @Getter private Actividad actividad;
    
    @OneToOne
    @Setter @Getter private PeriodoDeImputacion periodoDeImputacion;

    public boolean isValid() {
        return this.actividad != null &&
                this.periodoDeImputacion != null;
    }
}
