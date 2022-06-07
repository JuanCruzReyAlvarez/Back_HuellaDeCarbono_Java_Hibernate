package dds.tp.carbono;

import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.model.sample.SampleModel;
import dds.tp.carbono.reader.ExcelImporter;

public class ExcelReaderTest {
    
    @Test
    public void test() {
        ExcelImporter reader = new ExcelImporter();

        String fileName = "sample2.xlsx";

        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(fileName)) {
            List<SampleModel> models = reader.importFrom(is, SampleModel.class);
            Assert.assertEquals(16, models.size());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
