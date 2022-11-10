package dds.tp.carbono.persistence;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.repository.organization.SectorRepository;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaMiembro;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaSector;

import org.junit.Test;

public class calculatorsTest {
    
    MiembroRepository miembroRepo = new MiembroRepository();
    SectorRepository sectorRepo = new SectorRepository();
    
    @Test

    public void calculoMiembro() throws Exception
    {
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate local_date = LocalDate.parse("2022-01-01", formatter);// input.getInicioPeriodo()

        
        System.out.println(local_date);
        PeriodoDeImputacion periodo =  new PeriodoDeImputacion(local_date, Periodicidad.ANUAL);//Periodicidad.valueOf(input.getFormaCalculo().toUpperCase()))
        
        CalculadorHuellaMiembro calculador = new CalculadorHuellaMiembro(this.miembroRepo.getById((Integer.parseInt("1"))), new FactorEmisionRepository(), periodo);//input.getMiembroId()
        
        //return calculador.calcular();

        
        System.out.println(calculador.calcular().getValor()   );
    }
    @Test

    public void calculateSector() throws Exception{

       

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate local_date = LocalDate.parse("2022-01-01", formatter);// input.getInicioPeriodo()
            
            PeriodoDeImputacion periodo =  new PeriodoDeImputacion(local_date,(Periodicidad.ANUAL));
            
            CalculadorHuellaSector calculador = new CalculadorHuellaSector(this.sectorRepo.getById(Integer.parseInt("1")),
                                                new FactorEmisionRepository(),                    
                                                periodo);
            
            System.out.println(calculador.calcular().getValor()  + "test sector " );
        
    }
}