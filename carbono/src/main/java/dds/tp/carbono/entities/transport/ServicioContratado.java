package dds.tp.carbono.entities.transport;

import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.repository.admin.ServicioContratadoRepository;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import lombok.Getter;
import lombok.Setter;

public class ServicioContratado implements MedioDeTransporte {
    private ServicioContratadoRepository repository;
    @Getter @Setter private Integer id;
    @Getter @Setter private TipoServicioContratado tipo;

    public ServicioContratado() {
        this.repository = new ServicioContratadoRepository();
    }

    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
        return calculador.calcularDistancia(inicio, fin);
    }
}

