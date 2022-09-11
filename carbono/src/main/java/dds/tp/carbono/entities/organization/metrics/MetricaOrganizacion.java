package dds.tp.carbono.entities.organization.metrics;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dds.tp.carbono.entities.organization.Organizacion;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="mentrica_Organizacion")
public class MetricaOrganizacion {

    @Id
    @GeneratedValue
    @Getter @Setter Integer id;

    @OneToOne
    @Setter @Getter private Actividad actividad;
    
    @Embedded
    @Setter @Getter private PeriodoDeImputacion periodoDeImputacion;

    @ManyToOne
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    @Setter @Getter private Organizacion organizacion;

    public boolean isValid() {
        return this.actividad != null &&
                this.periodoDeImputacion != null;
    }
}
