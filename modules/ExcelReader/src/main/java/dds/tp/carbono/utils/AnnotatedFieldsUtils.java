package dds.tp.carbono.utils;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import dds.tp.carbono.contracts.ExcelColumn;

public class AnnotatedFieldsUtils {

    public static Reflections getReflections(Class<?> clazz) {
        return new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forClass(clazz, clazz.getClassLoader()))
            .setScanners(Scanners.FieldsAnnotated));
    }

    public static Map<Integer, Field> fieldsToMap(Set<Field> fields) {
        Map<Integer, Field> attrs = new LinkedHashMap<>();

        fields.stream().forEach(f -> {

            ExcelColumn fieldExcelColumn = f.getAnnotation(ExcelColumn.class);

            if (fieldExcelColumn != null)
                attrs.put(fieldExcelColumn.index(), f);
        });

        return attrs;
    }
}
