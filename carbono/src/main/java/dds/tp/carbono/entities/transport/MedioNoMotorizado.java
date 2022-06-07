package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import lombok.Getter;
import lombok.Setter;

public class MedioNoMotorizado implements MedioDeTransporte {
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoMedioNoMotorizado tipo;

    public MedioNoMotorizado(Integer id, TipoMedioNoMotorizado tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    
    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
        return calculador.calcularDistancia(inicio, fin);
    }
 
}

