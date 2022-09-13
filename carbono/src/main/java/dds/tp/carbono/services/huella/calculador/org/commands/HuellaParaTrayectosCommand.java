package dds.tp.carbono.services.huella.calculador.org.commands;

import java.time.Month;
import java.util.List;

import dds.tp.carbono.entities.huella.BuscadorFactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaTrayecto;
import lombok.Setter;

public class HuellaParaTrayectosCommand implements HuellaCommand {

    private List<Trayecto> trayectos;
    @Setter private BuscadorFactorEmision buscador;
    
    public HuellaParaTrayectosCommand(List<Trayecto> trayectos, PeriodoDeImputacion periodo) {
        
        if (periodo.getPeriodicidad().equals(Periodicidad.MENSUAL)){
        filtrarPorMes(periodo.getFechaInicio().getMonth(), trayectos);
        }
        filtrarPorAnio(periodo.getFechaInicio().getYear(), trayectos);
        
    }

    private void filtrarPorAnio(int i, List<Trayecto> trayectos2) {

        for (Trayecto trayecto: this.trayectos) {
            if(i == trayecto.getFecha().getYear()){
                this.trayectos.add(trayecto);
            }
        }
    }

    private void filtrarPorMes(Month month, List<Trayecto> trayectos2) {
        for (Trayecto trayecto: this.trayectos) {
            if(month.equals(trayecto.getFecha().getMonth())){
                this.trayectos.add(trayecto);
            }
        }
    }


    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaTotal = new HuellaCarbono();

        for (Trayecto trayecto: this.trayectos) {
            HuellaCarbono huellaTrayecto = new CalculadorHuellaTrayecto(trayecto,buscador).calcular();
            huellaTotal = huellaTotal.suma(huellaTrayecto);
        }

        return huellaTotal;
    }
}
