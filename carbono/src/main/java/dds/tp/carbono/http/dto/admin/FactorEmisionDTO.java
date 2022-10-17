package dds.tp.carbono.http.dto.admin;


import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactorEmisionDTO {
    @Getter private String tipoActividad;
    @Getter private String tipoConsumo;
    @Getter private String unidad;
    @Getter private String valor;
    @Getter private String iD;

    
}
