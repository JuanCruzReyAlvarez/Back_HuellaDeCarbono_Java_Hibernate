package dds.tp.carbono.validators.tramo;

import dds.tp.carbono.entities.member.Tramo;

public class PuntoInicialValidator implements TramoValidatorCommand {

    @Override
    public Boolean validate(Tramo tramo) {
        return tramo.getPuntoA() != null;
    }
}
