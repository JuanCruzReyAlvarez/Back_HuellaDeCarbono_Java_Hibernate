package dds.tp.carbono.entities.member;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import lombok.Getter;
import lombok.Setter;

public class Miembro {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private String apellido;
    @Getter @Setter private TipoDocumento tipoDocumento;
    @Getter @Setter private String nroDocumento;
    @Getter @Setter private Set<SolicitudVinculacion> solicitudes;
    @Getter @Setter private Set<Trayecto> trayectos;

    public Miembro() {
        this.solicitudes = new HashSet<SolicitudVinculacion>();
    }

    public List<Trayecto> getTrayectosNoCompartidos() {
        return this.trayectos.stream().filter(t -> t.getTramos().stream()
            .allMatch(tramo -> tramo.getCompartidos().size() == 0))
        .collect(Collectors.toList());
    }

    public List<Trayecto> getTrayectosCompartidos() {
        return this.trayectos.stream().filter(t -> t.getTramos().stream()
            .allMatch(tramo -> tramo.getCompartidos().size() > 0))
        .collect(Collectors.toList());
    }
}