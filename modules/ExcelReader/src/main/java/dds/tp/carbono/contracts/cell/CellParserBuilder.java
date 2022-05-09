package dds.tp.carbono.contracts.cell;

import java.lang.reflect.Field;
import java.util.Map;

public abstract class CellParserBuilder {

    private Map<Class<?>, CellParser> parsers;

    public CellParserBuilder(Map<Class<?>, CellParser> parsers) {
        this.parsers = parsers;
    }

    public CellParser build(Field field) {
        return this.parsers.get(field.getType());
    }
}
