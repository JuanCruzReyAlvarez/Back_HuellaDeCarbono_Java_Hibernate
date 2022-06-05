package dds.tp.carbono.entities.transport;

import java.util.List;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class Linea {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private List<Estacion> estaciones;

    public Estacion getEstacionByUbicacion(PuntoGeografico ubicacion) throws Exception {
        for (Estacion estacion : this.getEstaciones())
            if (estacion.getUbicacion().getId().equals(ubicacion.getId()))
                return estacion;
        
        throw new Exception("No existe la estacion con esa ubicacion");
    }
}
