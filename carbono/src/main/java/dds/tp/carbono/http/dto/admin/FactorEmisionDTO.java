package dds.tp.carbono.http.dto.admin;


import lombok.Getter;

public class FactorEmisionDTO {
    @Getter private String tipo_de_actividad;
    @Getter private String tipo_de_consumo;
    @Getter private String unidad;
    @Getter private String valor;
}
