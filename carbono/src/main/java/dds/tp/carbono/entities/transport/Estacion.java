package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.entities.point.Ubicable;
import lombok.Getter;
import lombok.Setter;

public class Estacion implements Ubicable {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private PuntoGeografico ubicacion;
    @Getter @Setter private Double distanciaEstacionAnterior;
    @Getter @Setter private Estacion siguiente;
}
