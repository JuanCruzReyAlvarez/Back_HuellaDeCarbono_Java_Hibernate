package dds.tp.carbono.services.huella.calculador;

import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.organization.Organizacion;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import lombok.Getter;
import lombok.Setter;
import dds.tp.carbono.entities.organization.metrics.MetricaOrganizacion;

public class CalculadorHuellaCarbono {

    @Getter @Setter private PeriodoDeImputacion periodo;
    @Getter @Setter private Organizacion organizacion;

    public CalculadorHuellaCarbono(Organizacion org, PeriodoDeImputacion periodo){
        this.periodo = periodo;
        this.organizacion = org;
    }

    public HuellaCarbono calcula() throws Exception{
        
        HuellaCarbono huellaCarbono = this.calcularHuellaParaLasMetricas();
        return huellaCarbono;
    }

    public HuellaCarbono calcularHuellaParaLasMetricas()  throws Exception { //chequear el tema de catch y try en obtener HC

        List <MetricaOrganizacion> metricasACalcular = this.organizacion.getMetricas();
        
        metricasACalcular = filtrarMetricas();
        
        List <HuellaCarbono> huellasDeMetricas = obtenerHC(metricasACalcular);
        
        HuellaCarbono huellaTotal = new HuellaCarbono();
        huellaTotal = obtenerTotal(huellaTotal, huellasDeMetricas);
        
        return huellaTotal;
    } 


    private List<MetricaOrganizacion> filtrarMetricas( ){
        return this.organizacion.getMetricas()
        .stream()
        .filter(m ->m.getPeriodoDeImputacion()
        .equals(this.periodo))
        .collect(Collectors.toList());
    } 

    private List<HuellaCarbono> obtenerHC(List<MetricaOrganizacion> metricasACalcular) {
        return metricasACalcular
                                .stream()
                                .map(metrica -> {
                                    try {
                                        return calcularHuellaMetrica(metrica);
                                    } catch (Exception e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                    return null;
                                })
                                .collect(Collectors.toList());
    }

    private HuellaCarbono calcularHuellaMetrica(MetricaOrganizacion metrica ) throws Exception{
        CalculadorHuellaMetrica calculador = new CalculadorHuellaMetrica();
        calculador.setMetricaOrganizacion(metrica);
        return calculador.calcular();
    }
    
    private HuellaCarbono obtenerTotal(HuellaCarbono huellaTotal, List<HuellaCarbono> huellasDeMetricas) throws Exception {
        
        for (int i = 0; i < huellasDeMetricas.size(); i++){
            huellaTotal = huellasDeMetricas.get(i);
            HuellaCarbono hc2 = huellasDeMetricas.get(i+1);

            huellaTotal.suma(hc2);
        }
        return null;
    }

    

   
}
 