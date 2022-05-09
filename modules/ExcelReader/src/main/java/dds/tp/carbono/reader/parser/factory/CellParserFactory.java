package dds.tp.carbono.reader.parser.factory;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;

import dds.tp.carbono.contracts.cell.CellParser;
import dds.tp.carbono.contracts.cell.CellParserBuilder;
import dds.tp.carbono.reader.parser.builder.NumericCellParserBuilder;
import dds.tp.carbono.reader.parser.builder.TextCellParserBuilder;

public class CellParserFactory {
    private LinkedHashMap<CellType, CellParserBuilder> cellParserBuilders;

    public CellParserFactory() {
        this.cellParserBuilders = new LinkedHashMap<CellType, CellParserBuilder>() {
            {
                put(CellType.STRING, new TextCellParserBuilder());
                put(CellType.NUMERIC, new NumericCellParserBuilder());
            }
        };
    }

    public CellParser getParser(Cell cell, Field field) {
        CellParserBuilder parserBuiler = cellParserBuilders.get(cell.getCellType());
        
        if (parserBuiler == null)
            return null;
        
        return parserBuiler.build(field);
    }
}
