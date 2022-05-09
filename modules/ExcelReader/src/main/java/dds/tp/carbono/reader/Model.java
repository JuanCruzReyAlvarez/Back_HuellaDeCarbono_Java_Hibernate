package dds.tp.carbono.reader;

import dds.tp.carbono.contracts.ExcelColumn;
import dds.tp.carbono.contracts.Importable;
import lombok.Getter;
import lombok.Setter;

public class Model implements Importable {
    
    @Getter @Setter @ExcelColumn(index = 0)
    private String actividad;
}
