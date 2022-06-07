package dds.tp.carbono.validators.trayecto;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.member.Trayecto;

public class TrayectoValidator {
    
    private List<TrayectoValidatorCommand> commands;

    public TrayectoValidator() {
        this.commands = new ArrayList<TrayectoValidatorCommand>() {{
            add(new PuntoPartidaValidator());  
            add(new PuntoLlegadaValidator());    
            add(new MiembroValidator());    
            add(new TramosValidator());    
        }};
    }

    public Boolean validate(Trayecto trayecto) {
        return this.commands.stream().allMatch(v -> v.validate(trayecto));
    }
}
