package dds.tp.carbono.entities.member;

import java.util.List;

import dds.tp.carbono.entities.point.Ubicable;
import lombok.Getter;
import lombok.Setter;

public class Trayecto {
    @Getter @Setter private Integer id;
    @Getter @Setter private Ubicable puntoPartida;
    @Getter @Setter private Ubicable puntoLlegada;
    @Getter @Setter private List<Tramo> tramos;
}
