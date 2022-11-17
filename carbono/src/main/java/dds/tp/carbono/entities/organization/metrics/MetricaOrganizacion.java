package dds.tp.carbono.entities.organization.metrics;


import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

    @OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @Setter @Getter private Actividad actividad;
    
    @Embedded
    @Setter @Getter private PeriodoDeImputacion periodoDeImputacion;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "organizacion_id", referencedColumnName = "id")
    @Setter @Getter private Organizacion organizacion;

    
    public MetricaOrganizacion(){}
    
    public boolean isValid() {
        return this.actividad != null &&
                this.periodoDeImputacion != null;
    }
}
