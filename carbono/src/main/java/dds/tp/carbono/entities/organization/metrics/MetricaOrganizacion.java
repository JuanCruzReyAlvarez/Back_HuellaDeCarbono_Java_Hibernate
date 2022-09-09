package dds.tp.carbono.entities.organization.metrics;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="mentricaOrganizacion")
public class MetricaOrganizacion {

    @Id
    @GeneratedValue
    @Getter @Setter Integer id;

    @OneToOne
    @Setter @Getter private Actividad actividad;
    
    @Embedded
    @Setter @Getter private PeriodoDeImputacion periodoDeImputacion;

    public boolean isValid() {
        return this.actividad != null &&
                this.periodoDeImputacion != null;
    }
}
