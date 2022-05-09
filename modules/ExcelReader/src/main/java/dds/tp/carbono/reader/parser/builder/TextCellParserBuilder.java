package dds.tp.carbono.reader.parser.builder;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;

import dds.tp.carbono.contracts.cell.CellParser;
import dds.tp.carbono.contracts.cell.CellParserBuilder;
import dds.tp.carbono.reader.parser.LocalDateTimeCellParser;
import dds.tp.carbono.reader.parser.StringCellParser;

public class TextCellParserBuilder extends CellParserBuilder {

    public TextCellParserBuilder() {
        super(new LinkedHashMap<Class<?>, CellParser>() {{
            put(LocalDateTime.class, new LocalDateTimeCellParser());
            put(String.class, new StringCellParser());
        }});
    }
}
