package dds.tp.carbono.http.controllers.member.trayectos;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class TramoDTO {
    @Getter @Setter private String userId;
    @Getter @Setter private String calleInicial;
    @Getter @Setter private String alturaInicial;
    @Getter @Setter private String provinciaInicial;
    @Getter @Setter private String municipioInicial;
    @Getter @Setter private String localidadInicial;
    @Getter @Setter private String calleFinal;
    @Getter @Setter private String alturaFinal;
    @Getter @Setter private String provinciaFinal;
    @Getter @Setter private String municipioFinal;
    @Getter @Setter private String localidadFinal;
    @Getter @Setter private String tipo_Medio_De_Transporte;
    @Getter @Setter private String tipo_de_No_Motorizado;
    @Getter @Setter private String tipo_combustible_Servicio_Contratado;
    @Getter @Setter private String linea_Servicio_Contratado;
    @Getter @Setter private String tipo_transporte_publico;
    @Getter @Setter private String linea_transporte_publico;
    @Getter @Setter private String tipo_Vehiculo_Particular;
    @Getter @Setter private String tipo_combustible_Vehiculo_Particular;
    @Getter @Setter private String tipo_combustible_Transporte_Publico;
    @Getter @Setter private String idLinea;
    @Getter @Setter private String apellido_Acompañante;
    @Getter @Setter private List<AcompanianteDTO> acompaniante;
    

}



