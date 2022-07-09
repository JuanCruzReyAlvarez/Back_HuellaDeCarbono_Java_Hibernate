package dds.tp.carbono.services.huella.calculador;

import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;

import dds.tp.carbono.entities.organization.metrics.DatoActividad;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.converterUnidades.GramoUnidadHC;
import dds.tp.carbono.services.huella.converterUnidades.KilogramoUnidadHC;
import dds.tp.carbono.services.huella.converterUnidades.ToneladaUnidadHC;
import dds.tp.carbono.services.huella.converterUnidades.UnidadHC;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaMetrica implements CalculadorHuella {
    
    @Getter @Setter private FactorEmisionRepository repository;
    @Getter @Setter private HuellaCarbono huellaCarbono;
    @Getter @Setter private MetricaOrganizacion metricaOrganizacion;

    @Override
    public HuellaCarbono calcular() throws Exception {
        FactorEmision factorEmision =  getFactorEmision(this.metricaOrganizacion);
        DatoActividad datoActividad = getDatoActividad(this.metricaOrganizacion);

        this.huellaCarbono = calcularHCActividad(factorEmision, datoActividad);        
        return huellaCarbono;
    }
    
    private HuellaCarbono calcularHCActividad(FactorEmision factorEmision, DatoActividad datoActividad) throws Exception {
        this.huellaCarbono.setValor
                            (this.getDatoActividad(this.metricaOrganizacion).getValor() * this.getFactorEmision(this.metricaOrganizacion).getValor());
        this.huellaCarbono.setUnidad(determinarUnidad(factorEmision));
        return this.huellaCarbono;
    }


    private UnidadHC determinarUnidad(FactorEmision factorEmision) throws Exception {
        
        switch (factorEmision.getUnidad()) {

            case kgCO2eq_kWh : return new KilogramoUnidadHC();
            case kgCO2eq_KM : return new KilogramoUnidadHC();
            case kgCO2eq_M3 : return new KilogramoUnidadHC();
            case kgCO2eq_KG : return new KilogramoUnidadHC();
            case kgCO2eq_LT : return new KilogramoUnidadHC();
            case gCO2eq_KG : return new GramoUnidadHC();
            case gCO2eq_KM : return new GramoUnidadHC();
            case gCO2eq_LT : return new GramoUnidadHC();
            case gCO2eq_M3 : return new GramoUnidadHC();
            case gCO2eq_kWh: return new GramoUnidadHC();
            case tnCO2eq_KG : return new ToneladaUnidadHC();
            case tnCO2eq_KM : return new ToneladaUnidadHC();
            case tnCO2eq_LT : return new ToneladaUnidadHC();
            case tnCO2eq_M3 : return new ToneladaUnidadHC();
            case tnCO2eq_kWh : return new ToneladaUnidadHC();
        
            default: throw new Exception("Tipo de consumo no existente");
        }
    }

    private FactorEmision getFactorEmision(MetricaOrganizacion metrica){
        return repository.get(metrica.getTipoDeConsumo(), metrica.getTipoActividad());       
    }

    private DatoActividad getDatoActividad(MetricaOrganizacion metrica){
        
        return metrica.getActividad().getDatoActividad();
    }

  
}

