package dds.tp.carbono.entities.member;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.point.PuntoGeografico;
import lombok.Getter;
import lombok.Setter;

public class Trayecto {
    @Getter @Setter private Integer id;
    @Getter @Setter private PuntoGeografico puntoPartida;
    @Getter @Setter private PuntoGeografico puntoLlegada;
    @Getter @Setter private List<Tramo> tramos;
    @Getter @Setter private Miembro miembro;

    public Trayecto() {
        this.tramos = new ArrayList<Tramo>();
    }

    public Boolean isValid() {
        if (this.puntoPartida == null || this.puntoLlegada == null || this.tramos.size() == 0 || this.miembro == null )
            return false;
             
        if (!this.tramosValidos())
            return false;
        
        if (!this.puntoInicialYFinalCongruente())
            return false;
        
        return true;
    }

    private boolean tramosValidos() {
        return this.tramos.stream().allMatch(tramo -> tramo.isValid());
    }

    private boolean puntoInicialYFinalCongruente() {
        return this.tramos.get(0).getPuntoA().getId().equals(this.puntoPartida.getId()) &&
               this.tramos.get(this.tramos.size() - 1).getPuntoB().getId().equals(this.puntoLlegada.getId());
    }
}
