package dds.tp.carbono.entities.transport;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "linea")
public class Linea {
    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;
    
    @Column
    @Getter @Setter private String nombre;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="linea_id", referencedColumnName = "id")
    @Getter @Setter private List<Estacion> estaciones;

    public Linea(){}

    public Estacion getEstacionByUbicacion(PuntoGeografico ubicacion) throws Exception {
        for (Estacion estacion : this.getEstaciones())
            if (estacion.getUbicacion().getId().equals(ubicacion.getId()))
                return estacion;
        
        throw new Exception("No existe la estacion con esa ubicacion");
    }
}
