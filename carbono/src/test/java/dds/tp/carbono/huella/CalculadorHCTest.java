/*package dds.tp.carbono.huella;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dds.tp.carbono.dao.huella.FactorEmisionDao;
import dds.tp.carbono.entities.huella.BuscadorMiembros;
import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.huella.UnidadFE;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.Actividad;
import dds.tp.carbono.entities.organization.metrics.CombustionFija;
import dds.tp.carbono.entities.organization.metrics.Consumo;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.Unidad;
import dds.tp.carbono.services.huella.calculador.org.CalculadorHuellaOrganizacion;
import dds.tp.carbono.entities.huella.BuscadorFactorEmision;

public class CalculadorHCTest {


    @Before
    public void inicializarRepositoryMockFE() {
        FactorEmision factorGasNatural = new FactorEmision(TipoDeConsumo.GasNatural, TipoActividad.Combustion_Fija, 4.00, UnidadFE.kgCO2eq_M3);
        FactorEmisionDao.getInstance().save(factorGasNatural);
        
    }


    
    @Test 
    public void calcularHuellaParaLasMetricasTest() throws Exception {
        Organizacion org = this.crearOrganizacionConMetricas();
        PeriodoDeImputacion periodo = this.buildPeriodoDeImputacion();
        BuscadorFactorEmision buscadorDeEmision = this.inicializarBuscador();
        CalculadorHuellaOrganizacion calculador = new CalculadorHuellaOrganizacion(org, periodo,buscadorDeEmision);
        
        HuellaCarbono huella = calculador.calcula();
        System.out.print(huella.getValor());
        Assert.assertEquals(Double.valueOf(1206.00), huella.getValor());
    }

    //-----------------------------------INSTANCIAS ----------------------------------------------

    private Organizacion crearOrganizacionConMetricas() throws Exception {
        return buildOrganizacion(new ArrayList<MetricaOrganizacion>() {{
            add(crearMetricaCombustionFija());
            add(crearMetricaCombustionFija());
            add(crearMetricaCombustionFija());
        }});
    }

    private MetricaOrganizacion crearMetricaCombustionFija() throws Exception {
        Consumo consumo = buildConsumo(100.5, Periodicidad.ANUAL, Unidad.KG, TipoDeConsumo.GasNatural);
        Actividad actividad = buildActividadCombustionFija(consumo);
        PeriodoDeImputacion periodoDeImputacion = buildPeriodoDeImputacion();
        return buildMetricaOrganizacion(actividad , TipoActividad.Combustion_Fija, TipoDeConsumo.GasNatural, periodoDeImputacion);
    }

    //----------------------------------CONSTRUCTORES----------------------------------------

    private Organizacion buildOrganizacion(List<MetricaOrganizacion> metricas) {
        Organizacion org = new Organizacion();
        org.addMetricas(metricas);
        BuscadorMiembros buscadorMiembro = new BuscadorMiembros();
        org.setBuscador(buscadorMiembro);
        return org;
    }

    
    private BuscadorFactorEmision inicializarBuscador() throws Exception {
        List<FactorEmision> factores = new ArrayList<>();

        FactorEmision factorGasNatural = new FactorEmision(TipoDeConsumo.GasNatural, TipoActividad.Combustion_Fija, 4.00, UnidadFE.kgCO2eq_M3);
        FactorEmision factorGNC = new FactorEmision(TipoDeConsumo.GNC, TipoActividad.Trayecto_Miembros, 4.00, UnidadFE.kgCO2eq_M3);
        FactorEmision factorNafta = new FactorEmision(TipoDeConsumo.Nafta, TipoActividad.Trayecto_Miembros, 3.00, UnidadFE.kgCO2eq_LT);
        FactorEmision factorDiesel = new FactorEmision(TipoDeConsumo.Diesel, TipoActividad.Trayecto_Miembros, 2.00, UnidadFE.kgCO2eq_LT);

        factores.add(factorGasNatural);
        factores.add(factorGNC);
        factores.add(factorNafta);
        factores.add(factorDiesel);

        return new BuscadorFactorEmision(factores);

    }

    private PeriodoDeImputacion buildPeriodoDeImputacion() throws Exception {
        PeriodoDeImputacion periodo = new PeriodoDeImputacion("2020");
        periodo.setPeriodicidad(Periodicidad.ANUAL);
        return periodo;
    }

    private Consumo buildConsumo(Double valor,Periodicidad periodicidad,Unidad unidad,TipoDeConsumo tipo) {
        Consumo consumo = new Consumo();
        consumo.setValor(valor);
        consumo.setPeriodicidad(periodicidad);
        consumo.setUnidad(unidad);
        consumo.setTipo(tipo);
        return consumo;
    }

    private Actividad buildActividadCombustionFija (Consumo consumo) {
        Actividad actividad = new CombustionFija(consumo);
        return actividad;
    }

    private MetricaOrganizacion buildMetricaOrganizacion (Actividad actividad, TipoActividad tipoActividad, TipoDeConsumo tipoDeConsumo, PeriodoDeImputacion periodoDeImputacion) {
        MetricaOrganizacion metrica = new MetricaOrganizacion();
        metrica.setActividad(actividad);
        metrica.setPeriodoDeImputacion(periodoDeImputacion);

        return metrica;
    }
}*/