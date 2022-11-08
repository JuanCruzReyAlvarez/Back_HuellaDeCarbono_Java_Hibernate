package dds.tp.carbono.services.huella.calculador.org;


import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.huella.KilogramoUnidadHC;
import dds.tp.carbono.entities.organization.metrics.DatoActividad;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;

public class CalculadorHuellaMetrica extends CalculadorHuella {
    
    private MetricaOrganizacion metricaOrganizacion;
    private FactorEmisionRepository repository;

    public CalculadorHuellaMetrica(MetricaOrganizacion metrica, FactorEmisionRepository repository) {
        this.metricaOrganizacion = metrica;
        this.repository = repository;
    }

    @Override
    public HuellaCarbono calcular() {
        try {

            System.out.println("LLegue1111");

            FactorEmision factorEmision = getFactorEmision(this.metricaOrganizacion);

            System.out.println("LLegue2222");

            DatoActividad datoActividad = getDatoActividad(this.metricaOrganizacion);

            System.out.println("DATOACTIVIDAD:");
            System.out.println(datoActividad.getActividad().getTipoActividad().name());
            System.out.println(datoActividad.getUnidad());



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
  
        FactorEmision factor = new FactorEmision();

        factor = repository.get(metrica.getActividad().getTipoDeConsumo(), metrica.getActividad().getTipoActividad());

        return factor;
    }

    private DatoActividad getDatoActividad(MetricaOrganizacion metrica){
        return metrica.getActividad().getDatoActividad();
    }

    

}

