package dds.tp.carbono.validators.tramo;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.entities.member.Tramo;

public class TramoValidator {
    
    private List<TramoValidatorCommand> commands;

    public TramoValidator() {
        this.commands = new ArrayList<TramoValidatorCommand>() {{
            add(new PuntoInicialValidator());  
            add(new PuntoFinalValidator());  
            add(new MedioDeTransporteValidator());  
        }};
    }

    public Boolean validate(Tramo tramo) {
        return this.commands.stream().allMatch(v -> v.validate(tramo));
    }
}
