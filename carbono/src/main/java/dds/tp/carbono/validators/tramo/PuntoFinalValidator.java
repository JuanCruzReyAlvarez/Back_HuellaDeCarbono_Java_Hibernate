package dds.tp.carbono.validators.tramo;

import dds.tp.carbono.entities.member.Tramo;

public class PuntoFinalValidator implements TramoValidatorCommand {

    @Override
    public Boolean validate(Tramo tramo) {
        return tramo.getPuntoB() != null;
    }
}
