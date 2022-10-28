package dds.tp.carbono.services.reportes;

import java.time.LocalDate;
import java.util.List;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.IndicadorHCOrganizacion;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.services.huella.calculador.agenteSectorial.CalculadorHuellaSectorTerritorial;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;
import lombok.Getter;
import lombok.Setter;

public class reporteSectorTerritorial extends reporte {

    @Getter @Setter private SectorTerritorial sectorTerritorial;
    
    @Getter @Setter private List<HuellaCarbono> listaHCEvolucion;

    @Getter @Setter private List<IndicadorHCOrganizacion> indicadoresOrg;
    
    @Override
    public HuellaCarbono obtenerHuellaTotal() throws Exception {
        CalculadorHuellaSectorTerritorial calculador = new CalculadorHuellaSectorTerritorial(this.getSectorTerritorial(), this.getPeriodoDeImputacion());
        return calculador.calcular();
    }

    public List<HuellaCarbono> evolucionEntre(LocalDate periodo1, LocalDate periodo2) throws Exception {
        
        int i = 0;

        for (LocalDate date = periodo1; date.isBefore(periodo2); date.plusMonths(1)){
        
        PeriodoDeImputacion periodo = new PeriodoDeImputacion(date,Periodicidad.MENSUAL);

        HuellaCarbono hc = new HuellaCarbono();

        CalculadorHuellaSectorTerritorial calculador = new CalculadorHuellaSectorTerritorial(this.getSectorTerritorial(), periodo);
        hc = calculador.calcular();

        this.listaHCEvolucion.add(i, hc);
        i++;
        }    

        return this.listaHCEvolucion;
    }

    public List<IndicadorHCOrganizacion> composicion() throws Exception {
        
        List<Organizacion> organizaciones =  this.getSectorTerritorial().getOrganizaciones();
        
        for( Organizacion org: organizaciones){
            CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org, getPeriodoDeImputacion());
            IndicadorHCOrganizacion indicador = calculador.getIndicador();
            this.indicadoresOrg.add(indicador);
        }

        return this.indicadoresOrg;
    }
    
    
}
