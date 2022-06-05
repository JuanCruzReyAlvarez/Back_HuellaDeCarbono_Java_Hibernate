package dds.tp.carbono.entities.member;

import java.util.List;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class Trayecto {
    @Getter @Setter private Integer id;
    @Getter @Setter private PuntoGeografico puntoPartida;
    @Getter @Setter private PuntoGeografico puntoLlegada;
    @Getter @Setter private List<Tramo> tramos;
}