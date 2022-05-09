package dds.tp.carbono.reader.importable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import dds.tp.carbono.contracts.Importable;

public class ImportableFactory {

    private ImportableSheetRowProcessor imporableSheetRowProcessor;
    private ImportableBuilder importableBuilder;

    public ImportableFactory(Class<? extends Importable> importableType) {
        this.imporableSheetRowProcessor = new ImportableSheetRowProcessor();
        this.importableBuilder = new ImportableBuilder(importableType);
    }

    public Importable createImportable(Row row) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Importable importable = importableBuilder.newInstance(); 
        Map<Integer, Field> annotatedFields = importableBuilder.getAnnotatedFields();
        Iterator<Cell> iterator = row.iterator();

        while (iterator.hasNext())
        {
            Cell cell = iterator.next();
            Field field = annotatedFields.get(cell.getColumnIndex());

            if (field != null)
                importable = imporableSheetRowProcessor.hidratateImportable(cell, field, importable);
        }

        return importable;
    }
}
