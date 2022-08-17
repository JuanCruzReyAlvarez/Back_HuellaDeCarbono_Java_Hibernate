package dds.tp.carbono.services.huella.calculador.member;

import java.util.List;

import dds.tp.carbono.entities.huella.BuscadorFactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.IndicadorHCSector;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import dds.tp.carbono.services.huella.calculador.org.filter.TrayectosCompartidosFilter;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaSector implements CalculadorHuella{

    @Getter @Setter private Sector sector;
    @Getter @Setter private Organizacion org;
    @Getter @Setter private BuscadorFactorEmision buscador;

    public CalculadorHuellaSector(Sector sector, BuscadorFactorEmision buscador){
        this.sector = sector;
        this.buscador = buscador;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaCarbono = this.calcularHuellaSector();
        return huellaCarbono;
    }

    private HuellaCarbono calcularHuellaSector() throws Exception {

        TrayectosCompartidosFilter trayectosFilter = new TrayectosCompartidosFilter(sector.getMiembros());

        List<Trayecto> trayectosFiltrados = trayectosFilter.filtrarCompartidos();
       
        HuellaCarbono huellaTotal = new HuellaCarbono();
        huellaTotal = aplicarCalculadorAMiembros(trayectosFiltrados);
        
        
        return huellaTotal;
    }


    private HuellaCarbono aplicarCalculadorAMiembros(List<Trayecto> trayectosFiltrados) throws Exception {
        
        HuellaCarbono hc = new HuellaCarbono();

        for(Trayecto trayecto: trayectosFiltrados){
            CalculadorHuellaMiembro calculador = new CalculadorHuellaMiembro(trayecto.getMiembro(), buscador);
            hc = hc.suma(calculador.calcular());
        }
        
        return hc;
    }

    public IndicadorHCSector getIndicador() throws Exception {
        
        IndicadorHCSector indicador = new IndicadorHCSector();
        HuellaCarbono hc = this.calcular();
        
        indicador.setUnidad(hc.getUnidad());
        indicador.setValor(hc.getValor()/(sector.getMiembros().size()));
        return indicador;
    }
  
}