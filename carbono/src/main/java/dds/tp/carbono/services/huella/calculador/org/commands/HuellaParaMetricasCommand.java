package dds.tp.carbono.services.huella.calculador.org.commands;

import java.util.List;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaMetrica;

public class HuellaParaMetricasCommand implements HuellaCommand {

    private List<MetricaOrganizacion> metricas;

    public HuellaParaMetricasCommand(List<MetricaOrganizacion> metricas) {
        this.metricas = metricas;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huella = new HuellaCarbono();
        
        for (MetricaOrganizacion metrica : this.metricas) {
            HuellaCarbono huellaMetrica = new CalculadorHuellaMetrica(metrica).calcular();
            
            if (huellaMetrica != null)
                huella = huella.suma(huellaMetrica);
        }
        
        return huella;
    }
}
