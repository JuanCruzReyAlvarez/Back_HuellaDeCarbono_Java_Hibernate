package dds.tp.carbono.utils;

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

public class TestUtils {
    public static Object readJson(String fileName, Class<?> clazz) throws Exception {
        try (InputStream is = TestUtils.class.getClassLoader().getResourceAsStream(fileName)) {
            return new Gson().fromJson(new InputStreamReader(is), clazz);
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}
