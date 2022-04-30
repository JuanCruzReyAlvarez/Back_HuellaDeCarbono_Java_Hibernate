package dds.tp.carbono.entities.member;

import dds.tp.carbono.entities.transport.MedioDeTransporte;
import lombok.Getter;
import lombok.Setter;

public class Tramo {
    @Getter @Setter private Integer id;
    @Getter @Setter private PuntoTramo puntoA;
    @Getter @Setter private PuntoTramo puntoB;
    @Getter @Setter private MedioDeTransporte transporte;
}
