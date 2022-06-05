package dds.tp.carbono.entities.member;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

public class TrayectoPendiente {
    @Getter @Setter private Integer id;
    @Getter @Setter private Tramo tramoCompartido;
    @Getter @Setter private List<Miembro> miembrosPendientes;

    public TrayectoPendiente(Tramo tramo) {
        this.tramoCompartido = tramo;
        this.miembrosPendientes = tramo.getCompartidos();
    }

    public Integer trayectoCreado(Miembro miembro) {
        this.miembrosPendientes.stream()
                               .filter(m -> !m.getId().equals(miembro.getId()))
                               .collect(Collectors.toList());

        return this.miembrosPendientes.size();
    }
}
