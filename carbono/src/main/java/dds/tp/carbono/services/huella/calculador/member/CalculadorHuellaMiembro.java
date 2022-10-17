package dds.tp.carbono.services.huella.calculador.member;

import java.time.Month;
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
    private List<Trayecto> trayectos;

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
        filtraPorPeriodo(this.getMiembro().getTrayectos(), periodo);

        for (Trayecto trayecto : trayectos) {
            CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto, buscador);
            
            hcMiembro = hcMiembro.suma(calculador.calcular());
        }
        
        return hcMiembro;
    }

    private void filtraPorPeriodo(Set<Trayecto> trayectos, PeriodoDeImputacion periodo) {
        
        if (periodo.getPeriodicidad().equals(Periodicidad.MENSUAL)){
        filtrarPorMes(periodo.getFechaInicio().getMonth(), trayectos);
        }
        filtrarPorAnio(periodo.getFechaInicio().getYear(), trayectos);
        
    }

    
    private void filtrarPorAnio(int i, Set<Trayecto> trayectos2) {

        for (Trayecto trayecto: this.trayectos) {
            if(i == trayecto.getFecha().getYear()){
                this.trayectos.add(trayecto);
            }
        }
    }

    private void filtrarPorMes(Month month, Set<Trayecto> trayectos2) {
        for (Trayecto trayecto: this.trayectos) {
            if(month.equals(trayecto.getFecha().getMonth())){
                this.trayectos.add(trayecto);
            }
        }
    }
}
