package dds.tp.carbono.validators.trayecto;

import dds.tp.carbono.entities.member.Trayecto;

public class MiembroValidator implements TrayectoValidatorCommand {

    @Override
    public Boolean validate(Trayecto trayecto) {
        return trayecto.getMiembro() != null;
    }
}
