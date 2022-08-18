package dds.tp.carbono.services.huella.calculador.org.filter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;


public class TrayectosCompartidosFilter {

    private List<Miembro> miembros;

    public TrayectosCompartidosFilter(List<Miembro> miembros) {
        this.miembros = miembros;
    }

    public List<Trayecto> filtrarCompartidos() {

        List<Trayecto> trayectos = new ArrayList<Trayecto>();
        List<Trayecto> trayectosCompartidos = new ArrayList<Trayecto>();

        for (Miembro miembro : this.miembros) {
            trayectos.addAll(miembro.getTrayectosNoCompartidos());
            trayectosCompartidos.addAll(miembro.getTrayectosCompartidos());
        }

        trayectos.addAll(filtrarPorMayorDistancia(trayectosCompartidos));

        return trayectos;
    }

    private List<Trayecto> filtrarPorMayorDistancia(List<Trayecto> trayectosCompartidos) {
        List<Trayecto> trayectoConDistanciaMayor = new ArrayList<Trayecto>();
        Set<Tramo> tramosCompartidos = new HashSet<>();
        
        for (Trayecto trayectoCompartido : trayectosCompartidos) {
            Tramo tramoCompartido = trayectoCompartido.getTramoCompartido();
            if (tramosCompartidos.contains(tramoCompartido))
                continue;
               
            trayectoConDistanciaMayor.add(trayectoConDistanciaMayor(tramoCompartido, trayectosCompartidos));
            tramosCompartidos.add(tramoCompartido);
        }

        return trayectoConDistanciaMayor;
    }

    private Trayecto trayectoConDistanciaMayor(Tramo tramoCompartido, List<Trayecto> trayectosCompartidos) {
        return trayectosCompartidos.stream()
            .filter(t -> tramoCompartido.equals(t.getTramoCompartido()))
            .max((t1, t2) -> t1.obtenerDistancia().compareTo(t2.obtenerDistancia()))
            .get();
    }
}
