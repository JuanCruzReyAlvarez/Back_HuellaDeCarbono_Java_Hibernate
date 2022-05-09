package dds.tp.carbono.reader.importable;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;

import dds.tp.carbono.contracts.Importable;

public class ImportableSheetParser {

    private ImportableSheet importableSheet;
    private ImportableFactory importableFactory;

    public ImportableSheetParser(ImportableSheet importableSheet) {
        this.importableSheet = importableSheet;
        this.importableFactory = new ImportableFactory(importableSheet.getClazz());
    }

    public List<? extends Importable> parse() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        List<Importable> importables = new ArrayList<>();
        
        for (Row row : importableSheet.getRows())
            importables.add(importableFactory.createImportable(row));  

        return importables;
    }
}
