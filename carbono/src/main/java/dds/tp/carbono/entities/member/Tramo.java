package dds.tp.carbono.entities.member;

import dds.tp.carbono.entities.point.Ubicable;
import dds.tp.carbono.entities.transport.MedioDeTransporte;
import lombok.Getter;
import lombok.Setter;

public class Tramo {
    @Getter @Setter private Integer id;
    @Getter @Setter private Ubicable puntoA;
    @Getter @Setter private Ubicable puntoB;
    @Getter @Setter private MedioDeTransporte transporte;
}
