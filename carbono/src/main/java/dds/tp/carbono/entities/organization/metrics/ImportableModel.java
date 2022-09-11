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

    @Getter @Setter @ExcelColumn(index = 3) 
    private String periodicidad;

    @Getter @Setter @ExcelColumn(index = 2)
    private Object valor;


    @Override
    public boolean isValid() {
        return actividad != null && tipoDeConsumo != null && periodoDeImputacion != null;
    }

    public boolean isActividadLogistica() throws Exception {
        return TipoActividad.Logistica_De_Productos_Servicios.equals(TipoActividad.getBy(this.actividad));
    }
}
