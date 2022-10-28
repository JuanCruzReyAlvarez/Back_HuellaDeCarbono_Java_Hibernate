package dds.tp.carbono.services.reportes;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.IndicadorHCSector;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.Sector;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaSector;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;
import lombok.Getter;
import lombok.Setter;

public class reporteOrganizacion extends reporte{

    @Getter @Setter private List<IndicadorHCSector> indicadoresSector;

    @Getter @Setter private Organizacion organizacion;

    @Getter @Setter private List<HuellaCarbono> listaHCEvolucion;


    @Override
    public HuellaCarbono obtenerHuellaTotal() throws Exception {
        CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(this.organizacion, this.getPeriodoDeImputacion());
        return calculador.calcula();
    }

    
    public List<HuellaCarbono> evolucionEntre(LocalDate periodo1, LocalDate periodo2) throws Exception {
        
        int i = 0;

        for (LocalDate date = periodo1; date.isBefore(periodo2); date.plusMonths(1)){
        
        PeriodoDeImputacion periodo = new PeriodoDeImputacion(date, Periodicidad.MENSUAL);
        //periodo.setFechaInicio(date);
        //periodo.setPeriodicidad(Periodicidad.MENSUAL);

        HuellaCarbono hc = new HuellaCarbono();

        CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(this.organizacion, periodo );
        hc = calculador.calcula();

        this.listaHCEvolucion.add(i, hc);
        i++;
        }    

        return this.listaHCEvolucion;
    }
    

    public List<IndicadorHCSector> composicion(LocalDate fecha) throws Exception {
        
        Set<Sector> sectores = this.getOrganizacion().getSectores();
        PeriodoDeImputacion periodo = new PeriodoDeImputacion(fecha, Periodicidad.MENSUAL);
        
        for( Sector s: sectores){
            CalculadorHuellaSector calculador = new CalculadorHuellaSector(s, new FactorEmisionRepository(), periodo);
            IndicadorHCSector indicador = calculador.getIndicador();
            this.indicadoresSector.add(indicador);
        }

        return this.indicadoresSector;
    }

}
