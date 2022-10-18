package dds.tp.carbono.entities.organization.metrics;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "dato_Actividad")
public class DatoActividad {

    @Id
    @GeneratedValue
    @Getter @Setter Integer id;

    @OneToOne
    @JoinColumn(name="actividad_id", referencedColumnName="id")
    @Getter @Setter Actividad actividad;
    
    @Column
    @Setter @Getter private Double valor;

    @Enumerated(value = EnumType.STRING)
    @Setter @Getter private Unidad unidad;

    public DatoActividad(){}
}