package dds.tp.carbono.services.huella.calculador.member;

import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.SolicitudVinculacion;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import dds.tp.carbono.services.huella.calculador.org.filter.TrayectosCompartidosFilter;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaSector implements CalculadorHuella{

    @Getter @Setter private Sector sector;
    @Getter @Setter private Organizacion org;

    public CalculadorHuellaSector(Sector sector){
        this.sector = sector;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaCarbono = this.calcularHuellaSector();
        return huellaCarbono;
    }

    private HuellaCarbono calcularHuellaSector() throws Exception {

        MiembroRepository repo = new MiembroRepository();
        TrayectosCompartidosFilter trayectosFilter = new TrayectosCompartidosFilter(repo.getBySector(sector));
        List<Trayecto> trayectosFiltrados = trayectosFilter.filtrarCompartidos();
       
        HuellaCarbono huellaTotal = new HuellaCarbono();
        huellaTotal = aplicarCalculadorAMiembros(trayectosFiltrados);
        
        
        return huellaTotal;
    }


    private HuellaCarbono aplicarCalculadorAMiembros(List<Trayecto> trayectosFiltrados) throws Exception {
        
        HuellaCarbono hc = new HuellaCarbono();

        for(Trayecto trayecto: trayectosFiltrados){
            CalculadorHuellaMiembro calculador = new CalculadorHuellaMiembro(trayecto.getMiembro());
            hc = hc.suma(calculador.calcular());
        }
        
        return hc;
    }

    
}