package dds.tp.carbono.reader.parser.builder;

import java.util.LinkedHashMap;

import dds.tp.carbono.contracts.cell.CellParser;
import dds.tp.carbono.contracts.cell.CellParserBuilder;
import dds.tp.carbono.reader.parser.DoubleCellParser;
import dds.tp.carbono.reader.parser.IntegerCellParser;

public class NumericCellParserBuilder extends CellParserBuilder {

    public NumericCellParserBuilder() {
        super(new LinkedHashMap<Class<?>, CellParser>() {{
            put(Double.class, new DoubleCellParser());
            put(Integer.class, new IntegerCellParser());
        }});
    }
}
