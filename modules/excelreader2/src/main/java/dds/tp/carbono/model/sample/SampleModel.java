package dds.tp.carbono.model.sample;

import dds.tp.carbono.model.Importable;
import dds.tp.carbono.model.annotations.ExcelColumn;
import dds.tp.carbono.model.annotations.ExcelRow;

@ExcelRow(first = 2)
public class SampleModel implements Importable {
    
    @ExcelColumn(index = 0)
    private String firstColum;

    @ExcelColumn(index = 1)
    private String secondColumn;

    @ExcelColumn(index = 2)
    private Double thirdColumn;

    @ExcelColumn(index = 3)
    private String fourthColumn;

    @ExcelColumn(index = 4)
    private String fifthColumn;

    @Override
    public boolean isValid() {
        return true;
    }
}
