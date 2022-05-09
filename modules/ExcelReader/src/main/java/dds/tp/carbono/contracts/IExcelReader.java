package dds.tp.carbono.contracts;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import dds.tp.carbono.contracts.IoC.Injectable;

public interface IExcelReader extends Injectable {
     <T extends Importable> List<T> read(InputStream is, Class<T> clazz) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException;
     <T extends Importable> List<T> read(String fileName, Class<T> clazz) throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException;
}
