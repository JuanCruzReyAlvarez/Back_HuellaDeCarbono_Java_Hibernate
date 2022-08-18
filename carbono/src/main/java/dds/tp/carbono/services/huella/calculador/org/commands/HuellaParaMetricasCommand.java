package dds.tp.carbono.services.huella.calculador.org.commands;

import java.util.List;

import dds.tp.carbono.entities.huella.BuscadorFactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaMetrica;

public class HuellaParaMetricasCommand implements HuellaCommand {

    private List<MetricaOrganizacion> metricas;
    private BuscadorFactorEmision buscador;

    public HuellaParaMetricasCommand(List<MetricaOrganizacion> metricas, BuscadorFactorEmision buscador) {
        this.metricas = metricas;
        this.buscador = buscador;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huella = new HuellaCarbono();
        
        for (MetricaOrganizacion metrica : this.metricas) {
            HuellaCarbono huellaMetrica = new CalculadorHuellaMetrica(metrica,buscador).calcular();
            
            if (huellaMetrica != null)
                huella = huella.suma(huellaMetrica);
        }
        
        return huella;
    }
}
