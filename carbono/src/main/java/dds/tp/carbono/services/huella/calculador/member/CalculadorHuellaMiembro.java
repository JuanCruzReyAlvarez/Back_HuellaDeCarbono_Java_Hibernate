package dds.tp.carbono.services.huella.calculador.member;

import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import lombok.Getter;
import lombok.Setter;

public class CalculadorHuellaMiembro implements CalculadorHuella {

    @Getter @Setter private Miembro miembro;

    public CalculadorHuellaMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
    
    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaCarbono = this.calcularHuellaMiembro();
        return huellaCarbono;
    }

    private HuellaCarbono calcularHuellaMiembro() throws Exception {
        
        HuellaCarbono hcMiembro = new HuellaCarbono();

        for (Trayecto trayecto : this.getMiembro().getTrayectos()) {
            CalculadorHuellaTrayecto calculador = new CalculadorHuellaTrayecto(trayecto);
            
            hcMiembro = hcMiembro.suma(calculador.calcular());
        }
        
        return hcMiembro;
    }
}
