package dds.tp.carbono.entities.transport;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;


import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.point.PuntoGeografico;
import dds.tp.carbono.services.distancia.CalculadorDistanciaServicioExterno;
import lombok.Getter;
import lombok.Setter;


@Entity

@PrimaryKeyJoinColumn(name="medio_transporte_id")
public class MedioNoMotorizado extends MedioDeTransporte {

    @Transient
    @Getter @Setter private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Getter @Setter private TipoMedioNoMotorizado tipo;

    @Transient
    @Setter private CalculadorDistanciaServicioExterno calculador = new CalculadorDistanciaServicioExterno();
    
    public MedioNoMotorizado (){}
    
    public MedioNoMotorizado(Integer id, TipoMedioNoMotorizado tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    
    @Override
    public Double calcularDistancia(PuntoGeografico inicio, PuntoGeografico fin) throws Exception {
        return calculador.calcularDistancia(inicio, fin);
    }

    @Override
    public TipoDeConsumo getCombustible() throws Exception {
        throw new Exception("no tiene combustible");
    }
    
    public void setTipoMedioNoMotorizadoByString( String tipo ){

        switch (tipo) {
            case "BICICLETA":
                this.setTipo(TipoMedioNoMotorizado.BICICLETA);
                break;
            case "MONOPATIN": 
                this.setTipo(TipoMedioNoMotorizado.MONOPATIN);
                break;
            case "PIE": 
                this.setTipo(TipoMedioNoMotorizado.PIE);
                break;
            case "OTRO":
                this.setTipo(TipoMedioNoMotorizado.OTRO); 
                break;

        }
    }
}

