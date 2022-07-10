package dds.tp.carbono.services.huella.calculador.member;

import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.HuellaCarbono;
import dds.tp.carbono.entities.member.Tramo;
import dds.tp.carbono.entities.member.Trayecto;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.repository.huella.FactorEmisionRepository;
import dds.tp.carbono.services.huella.calculador.CalculadorHuella;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculadorHuellaTrayecto implements CalculadorHuella {
    @Getter @Setter private Trayecto trayecto;
    @Getter @Setter private FactorEmisionRepository repository;

    public CalculadorHuellaTrayecto(Trayecto trayecto) {
        this.trayecto = trayecto;
        this.repository = new FactorEmisionRepository();
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaTotal = new HuellaCarbono();

        for (Tramo tramo: trayecto.getTramos())
            if(tramo.esCalculable())
                huellaTotal = huellaTotal.suma(this.calcular(tramo));

        return huellaTotal;
    }

    private HuellaCarbono calcular(Tramo tramo) {
        HuellaCarbono huellaTramo = new HuellaCarbono();
        
        try {
            TipoDeConsumo tipoConsumo = tramo.getTransporte().getCombustible();
            TipoActividad actividad = TipoActividad.Trayecto_Miembros;
            FactorEmision factorEmision = repository.get(tipoConsumo, actividad);
            huellaTramo.setValor(tramo.obtenerDistancia() * factorEmision.getValor());
        } catch (Exception ex) {
            log.error("Error al calcular HC para tramo", tramo, ex);
        }

        return huellaTramo;
    }
}
