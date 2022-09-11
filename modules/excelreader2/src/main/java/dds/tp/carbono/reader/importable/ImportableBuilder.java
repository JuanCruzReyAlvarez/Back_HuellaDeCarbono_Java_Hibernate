package dds.tp.carbono.reader.importable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import dds.tp.carbono.model.Importable;
import dds.tp.carbono.model.annotations.ExcelColumn;
import dds.tp.carbono.model.workbook.RowInfo;
import dds.tp.carbono.reader.fields.ReflectionHelper;

public class ImportableBuilder {

    private static final Class<ExcelColumn> ANNOTATION_FIELD = ExcelColumn.class;
    
    private Class<? extends Importable> importableType;

    public ImportableBuilder(Class<? extends Importable> importableType) {
        this.importableType = importableType;
    }

    public Importable build(RowInfo row) {
        Set<Field> fields = ReflectionHelper.getAnnotatedFields(ANNOTATION_FIELD, importableType);
        List<Object> values = row.getCellValues();
        
        return setValueInFields(fields, values, this.newInstance());
    }

    private Importable setValueInFields(Set<Field> fields, List<Object> values, Importable importable) {
        Iterator<Field> iterator = fields.iterator();
        
        while (iterator.hasNext())
            importable = setValueInField(iterator.next(), values, importable);
            
        return importable;
    }

    private Importable setValueInField(Field field, List<Object> values, Importable importable) {
        try {
            Integer index = field.getAnnotation(ANNOTATION_FIELD).index();
            Object value = values.get(index);
            field.setAccessible(true);
            field.set(importable, field.getType().cast(value));
            return importable;
        } catch (Exception e) {
            return importable;
        }
    }

    private Importable newInstance() {
        try {
            Constructor<? extends Importable> constructor = importableType.getConstructor();
            return importableType.cast(constructor.newInstance());
        } catch (Exception ex) {
            return null;
        }
    }
}
