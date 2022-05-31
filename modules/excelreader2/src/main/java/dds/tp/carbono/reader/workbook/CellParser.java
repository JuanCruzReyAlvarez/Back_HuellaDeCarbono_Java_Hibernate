package dds.tp.carbono.reader.workbook;

import org.apache.poi.ss.usermodel.Cell;

public class CellParser {

    public static Object getValue(Cell cell) {
        switch (cell.getCellType()) {
            case NUMERIC: return cell.getNumericCellValue();
            case STRING: return cell.getStringCellValue();
            default: return null;
        }
    }
}
