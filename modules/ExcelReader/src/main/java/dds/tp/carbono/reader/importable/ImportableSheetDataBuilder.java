package dds.tp.carbono.reader.importable;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import dds.tp.carbono.contracts.Importable;

public class ImportableSheetDataBuilder {
    
    private static final Integer SHEET_INDEX = 0;
    private static final Integer FIRST_DATA_ROW_INDEX = 2;

    public static ImportableSheet build(Class<? extends Importable> importableType, Workbook workbook) {
        Sheet sheet = workbook.getSheetAt(SHEET_INDEX);
        Iterator<Row> iterator = sheet.iterator();
        ImportableSheet importableSheet = new ImportableSheet(importableType);

        while(iterator.hasNext()) {
            Row row = iterator.next();
            if (row.getRowNum() >= FIRST_DATA_ROW_INDEX);
                importableSheet.getRows().add(iterator.next());
        }

        return importableSheet;
    }
}
