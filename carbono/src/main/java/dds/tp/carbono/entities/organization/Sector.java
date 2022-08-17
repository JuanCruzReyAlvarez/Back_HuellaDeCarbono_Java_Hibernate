package dds.tp.carbono.entities.organization;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaSector;
import lombok.Getter;
import lombok.Setter;

public class Sector {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private Organizacion organizacion;
    @Getter @Setter private Set<SolicitudVinculacion> solicitudes;
    
    public Sector(Integer id, String nombre, Organizacion organizacion, Set<SolicitudVinculacion> solicitudes) {
        this.id = id;
        this.nombre = nombre;
        this.organizacion = organizacion;
        this.solicitudes = solicitudes;
    }   

    public IndicadorHCSector getIndicador() throws Exception {
        
        IndicadorHCSector indicador = new IndicadorHCSector();
        HuellaCarbono hc = calcularHC();
        
        indicador.setUnidad(hc.getUnidad());
        indicador.setValor(hc.getValor()/cantidadMiembros());
        return indicador;
    }

    private int cantidadMiembros() {
        return solicitudes.stream().
        filter(n->n.getEstado() == EstadoSolicitudVinculacion.ACEPTADO).
        collect(Collectors.toList()).
        size();
    }

    public List<Miembro> miembros() {
        List<Miembro> miembros = new ArrayList<Miembro>() ;
        solicitudes.stream().
        filter(n->n.getEstado() == EstadoSolicitudVinculacion.ACEPTADO).
        collect(Collectors.toList()).forEach(a->miembros.add(a.getMiembro() ) );
        return miembros;
    }

    public HuellaCarbono calcularHC() throws Exception  {
        CalculadorHuellaSector calculador = new CalculadorHuellaSector(this);
        return calculador.calcular();
    }
}
