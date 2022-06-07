package dds.tp.carbono.entities.member;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.validators.trayecto.TrayectoValidator;
import lombok.Getter;
import lombok.Setter;

public class Trayecto {
    @Getter @Setter private Integer id;
    @Getter @Setter private PuntoGeografico puntoPartida;
    @Getter @Setter private PuntoGeografico puntoLlegada;
    @Getter @Setter private List<Tramo> tramos;
    @Getter @Setter private Miembro miembro;

    public Trayecto() {
        this.tramos = new ArrayList<Tramo>();
    }

    public Boolean isValid() {
        return new TrayectoValidator().validate(this);
    }
}
