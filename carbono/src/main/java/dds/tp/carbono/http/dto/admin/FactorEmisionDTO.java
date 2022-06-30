package dds.tp.carbono.http.dto.admin;

import dds.tp.carbono.entities.huella.FactorEmision;
import dds.tp.carbono.entities.huella.UnidadFE;
import dds.tp.carbono.entities.organization.metrics.TipoActividad;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FactorEmisionDTO {
    @Getter private String actividad;
    @Getter private String tipoConsumo;
    @Getter private String unidad;
    @Getter private Double valor;

    public FactorEmisionDTO(FactorEmision fe) {
        this.valor = fe.getValor();
        this.actividad = fe.getTipoActividad().toString();
        this.tipoConsumo = fe.getTipoDeConsumo().toString();
        this.unidad = fe.getUnidad().toString();
    }
    public FactorEmisionDTO(String actividad, String tipoConsumo, String unidad, String valor) {
        this.actividad = actividad;
        this.tipoConsumo = tipoConsumo;
        this.unidad = unidad;
        this.valor = Double.valueOf(valor);
    }

    public FactorEmision toFactorEmision() {
        FactorEmision fe = new FactorEmision();
        
        try {
            fe.setTipoActividad(TipoActividad.getBy(this.actividad));
            fe.setTipoDeConsumo(TipoDeConsumo.getBy(this.tipoConsumo));
            fe.setUnidad(UnidadFE.valueOfStr(this.unidad));
            fe.setValor(this.valor);
        } catch (Exception e) {
            log.error("unable to convert FactorEmisionDTO to model", this);
        }

        return fe;
    }
}
