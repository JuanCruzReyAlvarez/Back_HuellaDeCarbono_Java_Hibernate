package dds.tp.carbono.reader.workbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dds.tp.carbono.exception.InvalidFileException;
import dds.tp.carbono.model.workbook.FlatExcelData;

public class ExcelWorkbookHandler {

    private static final int SHEET_INDEX = 0;
    private Workbook workbook;

    public ExcelWorkbookHandler(InputStream is) throws InvalidFileException {
        try (Workbook workbook = new XSSFWorkbook(is)) {
            this.workbook = workbook;
        } catch (IOException e) {
            throw new InvalidFileException();
        }
    }

    public FlatExcelData flatMap() {
        FlatExcelData data = new FlatExcelData();
        Iterator<Row> rows = this.workbook.getSheetAt(SHEET_INDEX).iterator();
        rows.forEachRemaining(row -> data.addRowInfo(row));

        return data;
    }
}
