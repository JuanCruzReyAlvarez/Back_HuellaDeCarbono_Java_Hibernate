package dds.tp.carbono.contracts;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public interface IImportableBuilder {
    Map<Integer, Field> getAnnotatedFields();
    Importable newInstance() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;
}
