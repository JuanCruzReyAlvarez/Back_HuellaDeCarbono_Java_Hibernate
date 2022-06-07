package dds.tp.carbono.validators.trayecto;

import dds.tp.carbono.entities.member.Trayecto;

public class TramosValidator implements TrayectoValidatorCommand {

    @Override
    public Boolean validate(Trayecto trayecto) {
        return trayecto.getTramos().stream().allMatch(tramo -> tramo.isValid());
    }
}
