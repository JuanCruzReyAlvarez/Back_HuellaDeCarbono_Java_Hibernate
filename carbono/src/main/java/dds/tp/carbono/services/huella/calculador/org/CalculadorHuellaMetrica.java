package dds.tp.carbono.services.huella.calculador.org;

import dds.tp.carbono.entities.huella.BuscadorFactorEmision;
import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.huella.KilogramoUnidadHC;
import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.DatoActividad;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;

public class CalculadorHuellaMetrica extends CalculadorHuella {
    
    private MetricaOrganizacion metricaOrganizacion;

    public CalculadorHuellaMetrica(MetricaOrganizacion metrica, BuscadorFactorEmision buscador) {
        this.metricaOrganizacion = metrica;
        this.buscador = buscador;
    }

    @Override
    public HuellaCarbono calcular() {
        try {
            FactorEmision factorEmision = getFactorEmision(this.metricaOrganizacion);
            DatoActividad datoActividad = getDatoActividad(this.metricaOrganizacion);
            return resolverHC(factorEmision, datoActividad);        
        } catch (Exception ex) {
            return null;
        }
    }
    
    private HuellaCarbono resolverHC(FactorEmision factorEmision, DatoActividad datoActividad) throws Exception {
        HuellaCarbono hc = new HuellaCarbono();

        hc.setValor(datoActividad.getValor() * factorEmision.getValor());
        hc.setUnidad(new KilogramoUnidadHC());

        return hc;
    }

    private FactorEmision getFactorEmision(MetricaOrganizacion metrica){
        Actividad actividad = metrica.getActividad();
        return buscador.buscarPorConsumoActividad(actividad.getTipoDeConsumo(), actividad.getTipoActividad());       
    }

    private DatoActividad getDatoActividad(MetricaOrganizacion metrica){
        return metrica.getActividad().getDatoActividad();
    }
}

