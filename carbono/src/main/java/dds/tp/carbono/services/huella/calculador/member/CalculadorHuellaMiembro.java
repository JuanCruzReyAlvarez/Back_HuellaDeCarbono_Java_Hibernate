package dds.tp.carbono.services.huella.calculador.member;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaMiembro extends CalculadorHuella {

    @Getter @Setter private Miembro miembro;
   

    public CalculadorHuellaMiembro(Miembro miembro,FactorEmisionRepository buscador,PeriodoDeImputacion periodo ) {
        this.miembro = miembro;
        this.buscador = buscador;
        this.periodo = periodo;
        
    }
    
    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaCarbono = this.calcularHuellaMiembro();
        return huellaCarbono;
    }

    private HuellaCarbono calcularHuellaMiembro() throws Exception {
        
        HuellaCarbono hcMiembro = new HuellaCarbono();

        List<Trayecto> trayectos = new ArrayList<Trayecto>();

        trayectos = filtraPorPeriodo(this.getMiembro().getTrayectos(), periodo);


        for (Trayecto trayecto : trayectos) {
            
            CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto, buscador);
           
            
            hcMiembro = hcMiembro.suma(calculador.calcular());
           
        }
        
        return hcMiembro;
    }

    private List<Trayecto> filtraPorPeriodo(Set<Trayecto> trayectos, PeriodoDeImputacion periodo) {
        
        List<Trayecto> trayectosFiltrados = new ArrayList<Trayecto>();

        if (periodo.getPeriodicidad().equals(Periodicidad.MENSUAL)){
           
        trayectosFiltrados = filtrarPorMes(periodo.getFechaInicio().getMonth(), trayectos);
        }

        trayectosFiltrados = filtrarPorAnio(periodo.getFechaInicio().getYear(), trayectos);
        
        return trayectosFiltrados;
        
    }

    
    private List<Trayecto> filtrarPorAnio(int i, Set<Trayecto> trayectos2) {
        
        List<Trayecto> trayectosFiltrados = new ArrayList<Trayecto>();
       
        for (Trayecto trayecto: trayectos2) {
        System.out.println(trayecto.getId() + " "+ trayecto.getFecha());}

        for (Trayecto trayecto: trayectos2) {
            
            if(i == trayecto.getFecha().getYear()){
                
                trayectosFiltrados.add(trayecto);
              
            }
        }

        return trayectosFiltrados;
    }

    private List<Trayecto> filtrarPorMes(Month month, Set<Trayecto> trayectos2) {
        
        List<Trayecto> trayectosFiltrados = new ArrayList<Trayecto>();

        for (Trayecto trayecto: trayectos2) {
            if(month.equals(trayecto.getFecha().getMonth())){
                trayectosFiltrados.add(trayecto);
            }
        }
        return trayectosFiltrados;  
    }
}
