/*package dds.tp.carbono.services.huella.calculador.agenteSectorial;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;

import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;

public class CalculadorHuellaSectorTerritorial extends CalculadorHuella {

    private SectorTerritorial sector;
    PeriodoDeImputacion periodo;


    public CalculadorHuellaSectorTerritorial(SectorTerritorial sector, PeriodoDeImputacion periodo) {
        this.sector = sector;
        this.periodo = periodo;

    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huella = new HuellaCarbono();
        
        for (Organizacion org : this.sector.getOrganizaciones()) {
            CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org,periodo);
            huella = huella.suma(calculador.calcula());
        }

        return huella;
    }
}
 */

 

package dds.tp.carbono.services.huella.calculador.agenteSectorial;

import java.util.List;

import dds.tp.carbono.entities.agenteSectorial.SectorMunicipal;
import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.agenteSectorial.SectorTerritorialRepository;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;

public class CalculadorHuellaSectorTerritorial extends CalculadorHuella {

    private SectorTerritorial sector;
    PeriodoDeImputacion periodo;


    public CalculadorHuellaSectorTerritorial(SectorTerritorial sector, PeriodoDeImputacion periodo) {
        this.sector = sector;
        this.periodo = periodo;

    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        
        HuellaCarbono huella = new HuellaCarbono();


        switch (this.sector.tipo()) {
            case "PROVINCIAL" : huella = calculoProvincial();
            break;
            case "MUNICIPAL"  : huella = calculoMunicipal(this.sector);
            break;
            
        
    }
        return huella;
}

    private HuellaCarbono calculoMunicipal(SectorTerritorial sector2) throws Exception {
        
        HuellaCarbono huella = new HuellaCarbono();

        for (Organizacion org : sector2.getOrganizaciones()) {
            CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org,periodo);
            huella = huella.suma(calculador.calcula());
        }
        return huella;
    }

    private HuellaCarbono calculoProvincial() throws Exception {
        
        HuellaCarbono huella = new HuellaCarbono();
        SectorTerritorialRepository terriRepo = new SectorTerritorialRepository();
        List<SectorMunicipal> sectoresMunicipales =  terriRepo.getSectorMuniBySectorProvincial(this.sector.getId());
      
        for (SectorMunicipal sm : sectoresMunicipales) {
            
            huella = huella.suma(calculoMunicipal(sm));
        }
        return huella;
    }
}



