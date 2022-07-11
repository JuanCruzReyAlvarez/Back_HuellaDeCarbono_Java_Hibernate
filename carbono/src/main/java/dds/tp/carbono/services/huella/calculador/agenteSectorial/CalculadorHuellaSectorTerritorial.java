package dds.tp.carbono.services.huella.calculador.agenteSectorial;

import dds.tp.carbono.entities.agenteSectorial.SectorTerritorial;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;

public class CalculadorHuellaSectorTerritorial implements CalculadorHuella {

    private SectorTerritorial sector;
    private PeriodoDeImputacion periodo;

    public CalculadorHuellaSectorTerritorial(SectorTerritorial sector, PeriodoDeImputacion periodo) {
        this.sector = sector;
        this.periodo = periodo;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huella = new HuellaCarbono();
        
        for (Organizacion org : this.sector.getOrganizaciones()) {
            CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org, this.periodo);
            huella = huella.suma(calculador.calcula());
        }

        return huella;
    }
}
