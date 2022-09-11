package dds.tp.carbono.validators.trayecto;

import dds.tp.carbono.entities.member.Trayecto;

public class PuntoPartidaValidator implements TrayectoValidatorCommand {

    private static final int PRIMER_TRAMO = 0;

    @Override
    public Boolean validate(Trayecto trayecto) {
        return trayecto.getPuntoPartida() != null && trayecto.getTramos() != null
            && this.puntoDePartidaCongruenteEnTramos(trayecto);
    }

    private boolean puntoDePartidaCongruenteEnTramos(Trayecto trayecto) {
        return trayecto.getTramos().size() > 0 
            && trayecto.getTramos()
                       .get(PRIMER_TRAMO)
                       .getPuntoA()
                       .getId()
                       .equals(trayecto.getPuntoPartida()
                                       .getId());
    }
}
