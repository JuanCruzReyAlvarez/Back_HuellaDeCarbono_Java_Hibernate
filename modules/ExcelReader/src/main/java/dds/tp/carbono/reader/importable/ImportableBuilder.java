package dds.tp.carbono.reader.importable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

import dds.tp.carbono.contracts.ExcelColumn;
import dds.tp.carbono.contracts.IImportableBuilder;
import dds.tp.carbono.contracts.Importable;
import dds.tp.carbono.utils.AnnotatedFieldsUtils;

public class ImportableBuilder implements IImportableBuilder {

    private final Class<? extends Annotation> EXCEL_COLUIMN_FIELD_ANNOTATION = ExcelColumn.class;

    private Class<? extends Importable> clazz;
    private Map<Integer, Field> annotatedFields;

    public ImportableBuilder(Class<? extends Importable> clazz) {
        this.clazz = clazz;
    }

    public Importable newInstance() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<? extends Importable> constructor = clazz.getConstructor();
        return clazz.cast(constructor.newInstance());
    }

    public Map<Integer, Field> getAnnotatedFields() {
        if (this.annotatedFields == null)
            this.annotatedFields = this.scanAnnotatedFields(EXCEL_COLUIMN_FIELD_ANNOTATION);
        
        return this.annotatedFields;
    }

    private Map<Integer, Field> scanAnnotatedFields(Class<? extends Annotation> annotation) {
        Set<Field> fields = AnnotatedFieldsUtils.getReflections(clazz).getFieldsAnnotatedWith(annotation);
        return AnnotatedFieldsUtils.fieldsToMap(fields);
    }
}
