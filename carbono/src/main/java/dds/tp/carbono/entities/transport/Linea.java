package dds.tp.carbono.entities.transport;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Linea {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private List<Estacion> estaciones;
}
