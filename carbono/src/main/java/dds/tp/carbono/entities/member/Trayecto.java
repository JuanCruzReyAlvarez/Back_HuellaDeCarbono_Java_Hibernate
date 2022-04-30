package dds.tp.carbono.entities.member;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Trayecto {
    @Getter @Setter private Integer id;
    @Getter @Setter private PuntoTramo puntoPartida;
    @Getter @Setter private PuntoTramo puntoLlegada;
    @Getter @Setter private List<Tramo> tramos;
}
