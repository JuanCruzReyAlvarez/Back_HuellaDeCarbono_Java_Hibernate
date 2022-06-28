package dds.tp.carbono.services.huella;

import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.ivy.plugins.repository.Repository;

public class CalculadorHuellaTrayecto implements CalculadorHuella{
    @Getter @Setter private Trayecto trayecto;
    @Getter @Setter private FactorEmisionRepository repository;

    public CalculadorHuellaTrayecto(Trayecto trayecto){
        this.trayecto = trayecto;
        this.repository = new FactorEmisionRepository();
    }

    @Override
    public HuellaCarbono calcular() {
        HuellaCarbono huellaTotal = new HuellaCarbono();

        for (Tramo tramo: trayecto.getTramos())
            if(tramo.esCalculable())
                huellaTotal = huellaTotal.suma(this.calcular(tramo));

        return huellaTotal;
    }

    private HuellaCarbono calcular(Tramo tramo) {
        HuellaCarbono huellaTramo = new HuellaCarbono();
        try {
            FactorEmision factorEmision = repository.get(tramo.getTransporte().getCombustible());
            huellaTramo.setValor(tramo.obtenerDistancia() * factorEmision.getValor());
            //TODO Falta settear la unidad
        } catch (Exception exception) {
            //TODO loggear un mensaje
        }
        return huellaTramo;
    }

}
