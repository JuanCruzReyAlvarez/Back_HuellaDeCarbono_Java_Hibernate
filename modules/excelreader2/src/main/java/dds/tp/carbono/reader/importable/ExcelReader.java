package dds.tp.carbono.reader.importable;

import java.util.ArrayList;
import java.util.List;

import dds.tp.carbono.model.Importable;
import dds.tp.carbono.model.annotations.ExcelRow;
import dds.tp.carbono.model.workbook.FlatExcelData;
import dds.tp.carbono.model.workbook.RowInfo;

public class ExcelReader {

    private static final Class<ExcelRow> ANNOTATION_CLASS = ExcelRow.class;

    private ImportableBuilder importableBuilder;
    private int firstRowIndex;

    public ExcelReader(Class<? extends Importable> importableType) {
        this.importableBuilder = new ImportableBuilder(importableType);
        this.firstRowIndex = importableType.getAnnotation(ANNOTATION_CLASS).first();
    }

    public List<Importable> read(FlatExcelData excelData) {
        List<Importable> importableList = new ArrayList<>();
        
        for (RowInfo row : excelData.getRowsInfo())
            if (row.getIndex() >= firstRowIndex)
                importableList.add(importableBuilder.build(row));

        return importableList;
    } 
}
