package dds.tp.carbono.entities.organization;

import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaSector;
import lombok.Getter;
import lombok.Setter;

public class Sector {
    @Getter @Setter private Integer id;
    @Getter @Setter private String nombre;
    @Getter @Setter private Organizacion organizacion;
    @Getter @Setter private Set<SolicitudVinculacion> solicitudes;
    
    public Sector(Integer id, String nombre, Organizacion organizacion) {
        this.id = id;
        this.nombre = nombre;
        this.organizacion = organizacion;
    }   

    public IndicadorHCSector getIndicador() throws Exception {
        
        IndicadorHCSector indicador = new IndicadorHCSector();
        HuellaCarbono hc = calcularHC();
        
        indicador.setUnidad(hc.getUnidad());
        indicador.setValor(hc.getValor()/cantidadMiembros());
        return indicador;
    }

    private int cantidadMiembros() {
        MiembroRepository repo = new MiembroRepository();
        List<Miembro> miembros = repo.getBySector(this);

        return miembros.size();
    }

    public HuellaCarbono calcularHC() throws Exception  {
        CalculadorHuellaSector calculador = new CalculadorHuellaSector(this);
        return calculador.calcular();
    }
}
