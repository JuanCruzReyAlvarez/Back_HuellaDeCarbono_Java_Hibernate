package dds.tp.carbono.reader.importable;

import java.lang.reflect.Field;

import org.apache.poi.ss.usermodel.Cell;

import dds.tp.carbono.contracts.Importable;
import dds.tp.carbono.contracts.cell.CellParser;
import dds.tp.carbono.reader.parser.factory.CellParserFactory;

public class ImportableSheetRowProcessor {

    private CellParserFactory cellParserFactory;

    public ImportableSheetRowProcessor() {
        this.cellParserFactory = new CellParserFactory();
    }

    public Importable hidratateImportable(Cell cell, Field field, Importable importable) throws IllegalArgumentException, IllegalAccessException {
        CellParser parser = cellParserFactory.getParser(cell, field);
        
        if (parser == null)
            return importable;

        field.setAccessible(true);
        field.set(importable, parser.parse(cell));
        
        return importable;
    }
}
