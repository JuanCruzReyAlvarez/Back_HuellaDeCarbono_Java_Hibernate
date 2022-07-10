package dds.tp.carbono.services.huella.calculador.org.commands;

import java.util.List;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.services.huella.calculador.member.CalculadorHuellaTrayecto;

public class HuellaParaTrayectosCommand implements HuellaCommand {

    private List<Trayecto> trayectos;
    
    public HuellaParaTrayectosCommand(List<Trayecto> trayectos) {
        this.trayectos = trayectos;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaTotal = new HuellaCarbono();

        for (Trayecto trayecto: this.trayectos) {
            HuellaCarbono huellaTrayecto = new CalculadorHuellaTrayecto(trayecto).calcular();
            huellaTotal = huellaTotal.suma(huellaTrayecto);
        }

        return huellaTotal;
    }
}
