package dds.tp.carbono.entities.organization.metrics;

import dds.tp.carbono.model.Importable;
import dds.tp.carbono.model.annotations.ExcelColumn;
import dds.tp.carbono.model.annotations.ExcelRow;
import lombok.Getter;
import lombok.Setter;

@ExcelRow(first = 2)
public class ImportableModel implements Importable {
    @Getter @Setter @ExcelColumn(index = 0)
    private String actividad;

    @Getter @Setter @ExcelColumn(index = 1)
    private String tipoDeConsumo;

    @Getter @Setter @ExcelColumn(index = 4)
    private String periodoDeImputacion;

    @Override
    public boolean isValid() {
        return actividad != null && tipoDeConsumo != null && periodoDeImputacion != null;
    }
}
