package dds.tp.carbono.validators.trayecto;

import dds.tp.carbono.entities.member.Trayecto;

public class PuntoLlegadaValidator implements TrayectoValidatorCommand {

    @Override
    public Boolean validate(Trayecto trayecto) {
        return trayecto.getPuntoLlegada() != null
            && trayecto.getTramos().size() > 0 
            && this.puntoDeLlegadaCongruenteEnTramos(trayecto);
    }

    private boolean puntoDeLlegadaCongruenteEnTramos(Trayecto trayecto) {
        int ultimoIndex = trayecto.getTramos().size() - 1;
        return trayecto.getTramos()
                       .get(ultimoIndex)
                       .getPuntoB()
                       .getId()
                       .equals(trayecto.getPuntoLlegada()
                                       .getId());
    }
}
