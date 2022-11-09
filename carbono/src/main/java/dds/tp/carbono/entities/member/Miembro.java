package dds.tp.carbono.entities.member;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "miembro")
public class Miembro {

    @Id
    @GeneratedValue
    @Getter @Setter private Integer id;

    @Column
    @Getter @Setter private String nombre;

    @Column
    @Getter @Setter private String apellido;

    @Enumerated(value = EnumType.STRING)
    @Getter  @Setter private TipoDocumento tipoDocumento;

    @Column (name = "nro_documento")
    @Getter @Setter private String nroDocumento;

    @OneToMany (mappedBy = "miembro",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Getter @Setter private Set<SolicitudVinculacion> solicitudes;

    @OneToMany (mappedBy = "miembro",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Getter @Setter private Set<Trayecto> trayectos;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "trayecto_pendiente_id", referencedColumnName = "id")
    @Getter @Setter private TrayectoPendiente trayecto_pendiente;

    @OneToOne( fetch = FetchType.EAGER)
    @Getter @Setter private Usuario user;

    
    public Miembro() {
       
    }
    
    public Miembro(int a) {
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