package dds.tp.carbono.reader;

import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

import dds.tp.carbono.exception.InvalidFileException;
import dds.tp.carbono.model.Importable;
import dds.tp.carbono.model.workbook.FlatExcelData;
import dds.tp.carbono.reader.importable.ExcelReader;
import dds.tp.carbono.reader.workbook.ExcelWorkbookHandler;

public class ExcelImporter {

    private ExcelWorkbookHandler workbookHandler;
    private ExcelReader reader;

    public <T extends Importable> List<T> importFrom(InputStream is, Class<T> type) throws InvalidFileException {
        reader = new ExcelReader(type);
        workbookHandler = new ExcelWorkbookHandler(is);
        
        FlatExcelData excelData = workbookHandler.flatMap();
        List<Importable> importables = reader.read(excelData);
        
        return importables.stream().map(i -> type.cast(i)).collect(Collectors.toList());
    }
}
