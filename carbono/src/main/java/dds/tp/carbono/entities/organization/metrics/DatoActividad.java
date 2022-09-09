package dds.tp.carbono.entities.organization.metrics;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "datoActividad")
public class DatoActividad {

    @Id
    @GeneratedValue
    @Getter @Setter Integer id;
    
    @Column
    @Setter @Getter private Double valor;

    @Enumerated(EnumType.STRING)
    @Setter @Getter private Unidad unidad;
}