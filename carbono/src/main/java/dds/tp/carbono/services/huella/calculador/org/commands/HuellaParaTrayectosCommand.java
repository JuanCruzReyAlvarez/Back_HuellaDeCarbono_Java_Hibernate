package dds.tp.carbono.services.huella.calculador.org.commands;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.metrics.Periodicidad;
import dds.tp.carbono.entities.organization.metrics.PeriodoDeImputacion;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaTrayecto;
import lombok.Setter;

public class HuellaParaTrayectosCommand implements HuellaCommand {

    private List<Trayecto> trayectos;
    private List<Trayecto> trayectosNoAnualesFiltrados;
    @Setter private FactorEmisionRepository buscador;
    
    public HuellaParaTrayectosCommand(List<Trayecto> trayectos, PeriodoDeImputacion periodo) {
        this.trayectos = new ArrayList<Trayecto>();
        this.trayectosNoAnualesFiltrados = new ArrayList<Trayecto>();
        this.buscador = new FactorEmisionRepository();
        System.out.println(periodo.getFechaInicio().getMonth());
        System.out.println(trayectos.size());
        System.out.println(trayectos.get(0).getId());
        System.out.println(trayectos.get(0).getFecha());
        System.out.println(trayectos.get(0).getMiembro().getNombre());
        System.out.println(trayectos.get(0).getMiembro().getNombre());
        System.out.println(trayectos.get(0).getFecha().getMonth());
        System.out.println(periodo.getFechaInicio().getMonth());
        


        if (periodo.getPeriodicidad().equals(Periodicidad.MENSUAL)){
            System.out.println("entro a primer if");
        filtrarPorMes(periodo.getFechaInicio().getMonth(), trayectos);
        System.out.println("viendo trayectos222");
        }

        filtrarPorAnio(periodo.getFechaInicio().getYear(), trayectos);
        System.out.println("terminamos aca2");
        
    }

    private void filtrarPorAnio(int i, List<Trayecto> trayectos) {

        for (Trayecto trayecto: trayectos) {
            if(i == trayecto.getFecha().getYear()){
                this.trayectos.add(trayecto);
                System.out.println("bueno parece q vamos bien");
            }
        }
    }

    private void filtrarPorMes(Month month, List<Trayecto> trayectos) {
        System.out.println("ajam");
        for (Trayecto trayecto: trayectos) {
            System.out.println("ysi");
            if(month.equals(trayecto.getFecha().getMonth())){
                this.trayectosNoAnualesFiltrados.add(trayecto);
                System.out.println("viendo trayectos333");
            }
        }
    }


    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaTotal = new HuellaCarbono();

        for (Trayecto trayecto: this.trayectos) {
            CalculadorHuellaTrayecto calculadorTrayecto = new CalculadorHuellaTrayecto(trayecto,buscador);
            HuellaCarbono huellaTrayecto = calculadorTrayecto.calcular();
            System.out.println("2NUMERO FINAL TRAYECTO");
            System.out.println(huellaTotal.suma(huellaTrayecto).getValor());
            huellaTotal = huellaTotal.suma(huellaTrayecto);
        }
        System.out.println("SALIMOS");
        return huellaTotal;
    }
}
