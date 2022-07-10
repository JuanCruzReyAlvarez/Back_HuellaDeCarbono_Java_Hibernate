package dds.tp.carbono.huella;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.tp.carbono.dao.huella.FactorEmisionDao;
import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.huella.UnidadFE;
//import dds.tp.carbono.entities.huella.UnidadHC;
import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.CombustionFija;
import dds.tp.carbono.entities.organization.metrics.Consumo;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.Unidad;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaMetrica;

public class HuellaMetricaTest {

    @Before
    public void inicializarRepositoryMock(){
        FactorEmision factorGasNatural = new FactorEmision(TipoDeConsumo.GasNatural, TipoActividad.Combustion_Fija, 4.00, UnidadFE.kgCO2eq_M3);
        FactorEmisionDao.getInstance().save(factorGasNatural);
    }

    @Test
    public void calcularHuellaMetricaCombustionFijaTest() throws Exception{

        MetricaOrganizacion metrica = this.crearMetricaCombustionFija();
        CalculadorHuellaMetrica calculador = new CalculadorHuellaMetrica(metrica);
        HuellaCarbono huella = new HuellaCarbono();
    
        huella = calculador.calcular(); 
        Assert.assertEquals(Double.valueOf(402.00), huella.getValor());
    }
    
    //-----------------------------------INSTANCIAS ----------------------------------------------
    private MetricaOrganizacion crearMetricaCombustionFija() throws Exception{
        
        Consumo consumo = buildConsumo(100.5, Periodicidad.ANUAL, Unidad.KG, TipoDeConsumo.GasNatural);
        Actividad actividad = buildActividadCombustionFija(consumo);
        PeriodoDeImputacion periodoDeImputacion = buildPeriodoDeImputacion(Periodicidad.ANUAL);
        MetricaOrganizacion metrica = buildMetricaOrganizacion(actividad , TipoActividad.Combustion_Fija, TipoDeConsumo.GasNatural, periodoDeImputacion);
        
        
        return metrica;
    }
    //----------------------------------CONSTRUCTORES----------------------------------------

    private PeriodoDeImputacion buildPeriodoDeImputacion(Periodicidad periodicidad) throws Exception {
        PeriodoDeImputacion periodo = new PeriodoDeImputacion("03/2020");
        return periodo;
    }

    private Consumo buildConsumo(Double valor,Periodicidad periodicidad,Unidad unidad,TipoDeConsumo tipo){
        Consumo consumo = new Consumo();
        consumo.setValor(valor);
        consumo.setPeriodicidad(periodicidad);
        consumo.setUnidad(unidad);
        consumo.setTipo(tipo);
        return consumo;
    }

    private Actividad buildActividadCombustionFija (Consumo consumo){
        Actividad actividad = new CombustionFija(consumo);
        return actividad;
    }

    private MetricaOrganizacion buildMetricaOrganizacion (Actividad actividad, TipoActividad tipoActividad, TipoDeConsumo tipoDeConsumo, PeriodoDeImputacion periodoDeImputacion){
        MetricaOrganizacion metrica = new MetricaOrganizacion();
        metrica.setActividad(actividad);
        metrica.setPeriodoDeImputacion(periodoDeImputacion);
        return metrica;
    }
}
