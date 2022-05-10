package dds.tp.carbono.entities.organization.metrics;

import dds.tp.carbono.contracts.ExcelColumn;
import dds.tp.carbono.contracts.Importable;
import lombok.Getter;
import lombok.Setter;

public class MetricsExcelModel implements Importable {
    @Getter @Setter @ExcelColumn(index = 0)
    private String actividad;

    @Getter @Setter @ExcelColumn(index = 1)
    private String tipoDeConsumo;

    @Getter @Setter @ExcelColumn(index = 4)
    private String periodoDeImputacion;

    @Override
    public boolean isEmpty() {
        return actividad == null && tipoDeConsumo == null && periodoDeImputacion == null;
    }
}
