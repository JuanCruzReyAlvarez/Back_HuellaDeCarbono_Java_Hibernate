package dds.tp.carbono;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;

import dds.tp.carbono.contracts.IExcelReader;
import dds.tp.carbono.reader.ExcelReader;
import dds.tp.carbono.reader.Model;

public class ExcelReaderTest {
    
    @Test
    public void test() throws IllegalArgumentException, IllegalAccessException, NoSuchMethodException, SecurityException, InstantiationException, InvocationTargetException {
        IExcelReader reader = new ExcelReader();


        String fileName = "sample.xlsx";

        List<Model> models = reader.read(fileName, Model.class);

        System.out.println(models);
    }
}
