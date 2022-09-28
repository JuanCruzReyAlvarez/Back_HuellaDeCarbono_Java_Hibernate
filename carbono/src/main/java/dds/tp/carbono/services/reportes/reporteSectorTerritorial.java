package dds.tp.carbono.services.reportes;

import java.time.LocalDate;
import java.util.List;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.services.huella.calculador.agenteSectorial.CalculadorHuellaSectorTerritorial;
import lombok.Getter;
import lombok.Setter;

public class reporteSectorTerritorial extends reporte {

    @Getter @Setter private SectorTerritorial sectorTerritorial;
    
    @Getter @Setter private List<HuellaCarbono> listaHCEvolucion;
    
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
    
    
}
