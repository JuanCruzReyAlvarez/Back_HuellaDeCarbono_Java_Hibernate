package dds.tp.carbono.services.organizacion.metrics.factory;

import dds.tp.carbono.entities.organization.metrics.Consumo;
import dds.tp.carbono.entities.organization.metrics.ImportableModel;
import dds.tp.carbono.entities.organization.metrics.TipoDeConsumo;
import dds.tp.carbono.entities.organization.metrics.Unidad;

public class ConsumoFactory {
    public static Consumo getConsumo(ImportableModel importable) throws Exception {
        Consumo consumo = new Consumo();
        TipoDeConsumo tipoConsumo = TipoDeConsumo.getBy(importable.getTipoDeConsumo());
        
        consumo.setUnidad(Unidad.getBy(tipoConsumo));
        consumo.setValor(Double.valueOf((Double)importable.getValor()));
        consumo.setTipo(tipoConsumo);

        return consumo;
    }
}
