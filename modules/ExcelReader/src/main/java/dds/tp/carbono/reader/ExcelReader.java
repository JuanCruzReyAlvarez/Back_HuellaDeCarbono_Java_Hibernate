package dds.tp.carbono.reader;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dds.tp.carbono.contracts.IExcelReader;
import dds.tp.carbono.contracts.Importable;
import dds.tp.carbono.reader.importable.ImportableSheet;
import dds.tp.carbono.reader.importable.ImportableSheetDataBuilder;
import dds.tp.carbono.reader.importable.ImportableSheetParser;

public class ExcelReader implements IExcelReader {

    @Override
    public <T extends Importable> List<T> read(InputStream is, Class<T> importableType) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException {       
        try (Workbook workbook = new XSSFWorkbook(is)) {
            ImportableSheet importableSheet = ImportableSheetDataBuilder.build(importableType, workbook);
            List<? extends Importable> list = new ImportableSheetParser(importableSheet).parse();
            return list.stream().map(i -> importableType.cast(i)).collect(Collectors.toList());
        } catch (IOException e) {
            return null;
        }
    }    

    @Override
    public <T extends Importable> List<T> read(String fileName, Class<T> clazz) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            return read(is, clazz);
        } catch (IOException ex) {
            return null;
        }
    }
}
