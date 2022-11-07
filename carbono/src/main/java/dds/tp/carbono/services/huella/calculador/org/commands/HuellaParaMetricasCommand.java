package dds.tp.carbono.services.huella.calculador.org.commands;

import java.util.List;


import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaMetrica;

public class HuellaParaMetricasCommand implements HuellaCommand {

    private List<MetricaOrganizacion> metricas;
    private FactorEmisionRepository repository;

    public HuellaParaMetricasCommand(List<MetricaOrganizacion> metricas, FactorEmisionRepository repository) {
        this.metricas = metricas;
        this.repository = repository;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huella = new HuellaCarbono();
        System.out.println("LEGAMOS IMPRIMO TAMAÑO METRICAS");

        System.out.println(metricas.size());

        
        for (MetricaOrganizacion metrica : this.metricas) {
            CalculadorHuellaMetrica calculador = new CalculadorHuellaMetrica(metrica,repository);

            HuellaCarbono huellaMetrica = calculador.calcular();

            if (huellaMetrica != null)
                huella = huella.suma(huellaMetrica);
        }
        
        return huella;
    }
}
