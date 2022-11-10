package dds.tp.carbono.services.huella.calculador.org;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.huella.BuscadorMiembros;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.IndicadorHCOrganizacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaCommand;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaParaMetricasCommand;
import dds.tp.carbono.services.huella.calculador.org.commands.HuellaParaTrayectosCommand;
import dds.tp.carbono.services.huella.calculador.org.filter.TrayectosCompartidosFilter;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaOrganizacion {

    @Getter @Setter private PeriodoDeImputacion periodo;
    @Getter @Setter private Organizacion organizacion;
    @Getter @Setter public FactorEmisionRepository repository;
    @Getter @Setter private  List<Trayecto> trayectos ;
   
    List<HuellaCommand> diferentesCalculosParaOrg; 

    public CalculadorHuellaOrganizacion(Organizacion org, PeriodoDeImputacion periodo ) {
        this.periodo = periodo;
        this.organizacion = org;
        this.repository = new FactorEmisionRepository();
        this.trayectos = new ArrayList<Trayecto>();
        
        System.out.println("Dale que avanzamos00000");

        organizacion.setBuscador(new BuscadorMiembros());

        List<Miembro> miembros = new ArrayList<Miembro>() ;

        System.out.println("Dale que avanzamos00,33");

        miembros = organizacion.buscador.buscarMiembroPorOrganizacion((organizacion));

        System.out.println("Dale que avanzamos00,,5555");
        System.out.println(miembros.size());

        TrayectosCompartidosFilter trayectosFilter = new TrayectosCompartidosFilter(miembros);
        
        System.out.println("Dale que avanzamos1111");

        this.trayectos = trayectosFilter.filtrarCompartidos();
        
        if(trayectos.size()>0){
            this.diferentesCalculosParaOrg = new ArrayList<HuellaCommand>() {{
                add(new HuellaParaMetricasCommand(org.getMetricas(periodo), repository));
                add(new HuellaParaTrayectosCommand(trayectos, periodo)); 
            }};
        }else{
            this.diferentesCalculosParaOrg = new ArrayList<HuellaCommand>() {{
                add(new HuellaParaMetricasCommand(org.getMetricas(periodo), repository));
            }};

        }


        

        System.out.println("Dale que avanzamos2222222222222222222222222");
    } 
    

    public HuellaCarbono calcula() throws Exception {

        HuellaCarbono huellaCarbono = new HuellaCarbono();

        System.out.println(this.diferentesCalculosParaOrg.size());
        System.out.println("TAMAÑO COSAS A CALCULAR");

        //System.out.println(this.diferentesCalculosParaOrg.get(0).calcular());
       // System.out.println("VALORHUELLADESECOMMAND");
        
        for (HuellaCommand command : this.diferentesCalculosParaOrg)
            huellaCarbono = huellaCarbono.suma(command.calcular());

        return huellaCarbono;
    }

    public IndicadorHCOrganizacion getIndicador() throws Exception {
        
        IndicadorHCOrganizacion indicador = new IndicadorHCOrganizacion();
        HuellaCarbono hc = this.calcula();
        
        indicador.setUnidad(hc);
        indicador.setValor(hc.getValor()/(organizacion.getSectorTerritorial().getOrganizaciones().size()));
        return indicador;
    }

}
 