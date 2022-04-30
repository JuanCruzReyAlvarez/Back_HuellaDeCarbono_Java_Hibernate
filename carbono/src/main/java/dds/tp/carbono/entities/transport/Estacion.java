package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class Estacion {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private PuntoGeografico ubicacion;
}
