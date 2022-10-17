package dds.tp.carbono.services.huella.calculador.agenteSectorial;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
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
            CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org,periodo, new FactorEmisionRepository());
            huella = huella.suma(calculador.calcula());
        }

        return huella;
    }
}
