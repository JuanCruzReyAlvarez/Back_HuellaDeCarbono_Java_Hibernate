package dds.tp.carbono.services.huella;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.http.dto.huella.CalculatorDTO;
import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.repository.organization.OrganizacionRepository;
import dds.tp.carbono.repository.organization.SectorRepository;
import dds.tp.carbono.services.huella.calculador.agenteSectorial.CalculadorHuellaSectorTerritorial;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaMiembro;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaSector;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;


public class CalculatorService {

    OrganizacionRepository orgRepo;
    SectorRepository sectorRepo;
    MiembroRepository miembroRepo;
    SectorTerritorialRepository terriRepo;

    public CalculatorService(){
        this.orgRepo = new OrganizacionRepository();
        this.sectorRepo = new SectorRepository();
        this.miembroRepo = new MiembroRepository();
        this.terriRepo = new SectorTerritorialRepository();
    }

    public HuellaCarbono calculateMiembro(CalculatorDTO input) throws Exception {
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate local_date = LocalDate.parse(input.getInicioPeriodo(), formatter);// input.getInicioPeriodo()

        
        System.out.println(local_date);
        PeriodoDeImputacion periodo =  new PeriodoDeImputacion(local_date, Periodicidad.valueOf(input.getFormaCalculo().toUpperCase()));//Periodicidad.valueOf(input.getFormaCalculo().toUpperCase()))
        
        CalculadorHuellaMiembro calculador = new CalculadorHuellaMiembro(this.miembroRepo.getById((Integer.parseInt(input.getMiembroId()))), new FactorEmisionRepository(), periodo);//input.getMiembroId()
        
        return calculador.calcular();
    }

    public HuellaCarbono calculateSector(CalculatorDTO input) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate local_date = LocalDate.parse(input.getInicioPeriodo(), formatter);// input.getInicioPeriodo()
        
        PeriodoDeImputacion periodo =  new PeriodoDeImputacion(local_date,(Periodicidad.valueOf(input.getFormaCalculo().toUpperCase())));
        
        CalculadorHuellaSector calculador = new CalculadorHuellaSector(this.sectorRepo.getById(Integer.parseInt(input.getSectorId())),
                                            new FactorEmisionRepository(),                    
                                            periodo);
        
        return calculador.calcular();
    }

    public HuellaCarbono calculateOrg(CalculatorDTO input) throws Exception {


        DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate local_date = LocalDate.parse(input.getInicioPeriodo(), JEFormatter);

        System.out.println(local_date);

        Organizacion org = this.orgRepo.getById(Integer.parseInt(input.getOrganizacionId()));
       
        PeriodoDeImputacion periodo =  new PeriodoDeImputacion(local_date,(Periodicidad.valueOf(input.getFormaCalculo().toUpperCase())));
     
        CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org,periodo);
          
        return  calculador.calcula();
    }

    public HuellaCarbono calculateAgenteSectorial(CalculatorDTO input) throws Exception {

    
        DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate local_date = LocalDate.parse(input.getInicioPeriodo(), JEFormatter);
        
        PeriodoDeImputacion periodo =  new PeriodoDeImputacion(local_date,(Periodicidad.valueOf(input.getFormaCalculo().toUpperCase())));

        SectorTerritorial sector = this.terriRepo.getByIdUser(Integer.parseInt(input.getUserId())); 
        CalculadorHuellaSectorTerritorial calculador = new CalculadorHuellaSectorTerritorial(sector, periodo );
        return  calculador.calcular();
        
    }
    
}



