package dds.tp.carbono.services.huella.calculador.org;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.huella.BuscadorFactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaCommand;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaParaMetricasCommand;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaParaTrayectosCommand;
import dds.tp.carbono.services.huella.calculador.org.filter.TrayectosCompartidosFilter;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaOrganizacion {

    @Getter @Setter private PeriodoDeImputacion periodo;
    @Getter @Setter private Organizacion organizacion;
    @Getter @Setter public BuscadorFactorEmision buscador;
   
    List<HuellaCommand> diferentesCalculosParaOrg; 

    public CalculadorHuellaOrganizacion(Organizacion org, PeriodoDeImputacion periodo, BuscadorFactorEmision buscador) {
        this.periodo = periodo;
        this.organizacion = org;
        this.buscador = buscador;
        
    
        TrayectosCompartidosFilter trayectosFilter = new TrayectosCompartidosFilter
        (organizacion.buscador.buscarMiembroPorOrganizacion((organizacion)));

        this.diferentesCalculosParaOrg = new ArrayList<HuellaCommand>() {{
            add(new HuellaParaMetricasCommand(org.getMetricas(periodo),buscador));
            add(new HuellaParaTrayectosCommand(trayectosFilter.filtrarCompartidos(), periodo));
        }};
    } 
    

    public HuellaCarbono calcula() throws Exception {

        HuellaCarbono huellaCarbono = new HuellaCarbono();

        for (HuellaCommand command : this.diferentesCalculosParaOrg)
            huellaCarbono = huellaCarbono.suma(command.calcular());

        return huellaCarbono;
    }
}
 