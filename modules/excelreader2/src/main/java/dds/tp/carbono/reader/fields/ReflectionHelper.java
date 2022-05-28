package dds.tp.carbono.reader.fields;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

public class ReflectionHelper {
    public static Set<Field> getAnnotatedFields(Class<? extends Annotation> annotationType, Class<?> type) {
        Reflections reflections = getReflections(type);
        return reflections.getFieldsAnnotatedWith(annotationType);
    }

    private static Reflections getReflections(Class<?> clazz) {
        return new Reflections(new ConfigurationBuilder()
            .setUrls(ClasspathHelper.forClass(clazz, clazz.getClassLoader()))
            .setScanners(Scanners.FieldsAnnotated));
    }
}
