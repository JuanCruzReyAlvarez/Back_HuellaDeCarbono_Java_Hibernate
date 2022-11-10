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
public class CalculadorHuellaTrayecto extends CalculadorHuella {
    @Getter @Setter private Trayecto trayecto;

    public CalculadorHuellaTrayecto(Trayecto trayecto,FactorEmisionRepository buscador) {
        this.trayecto = trayecto;
        this.buscador = buscador;
    }

    @Override
    public HuellaCarbono calcular() throws Exception {
        HuellaCarbono huellaTotal = new HuellaCarbono();

        for (Tramo tramo: trayecto.getTramos()){

            if(tramo.esCalculable())
                huellaTotal = huellaTotal.suma(this.calcular(tramo));
          
            }
        return huellaTotal;             
    }

    private HuellaCarbono calcular(Tramo tramo) {
        HuellaCarbono huellaTramo = new HuellaCarbono();
        
        try {
            System.out.println("BUENAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAS");
            TipoDeConsumo tipoConsumo = tramo.getTransporte().getCombustible();
            System.out.println(tipoConsumo.toString());
            TipoActividad actividad = TipoActividad.Trayecto_Miembros;
            System.out.println(actividad.toString());
            FactorEmision factorEmision = buscador.get(tipoConsumo, actividad);
            System.out.println(factorEmision.getValor());

            System.out.println(tramo.getTransporte().getClass());
            System.out.println(tramo.getTransporte().getId());
            System.out.println(tramo.getTransporte().getCombustible());
            System.out.println(tramo.getPuntoA().getLocaldiad().getId());



            System.out.println(tramo.obtenerDistancia());
            huellaTramo.setValor(tramo.obtenerDistancia() * factorEmision.getValor());

        } catch (Exception ex) {
            log.error("Error al calcular HC para tramo", tramo, ex);
        }

        return huellaTramo;
    }
}
