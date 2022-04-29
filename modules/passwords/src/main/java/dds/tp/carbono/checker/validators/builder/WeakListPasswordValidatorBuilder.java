package dds.tp.carbono.checker.validators.builder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.TreeSet;

import com.google.gson.Gson;

import dds.tp.carbono.checker.validators.WeakListPasswordValidator;

public class WeakListPasswordValidatorBuilder {

    private static String FILE_NAME = "insecurePasswords.json";
    
    public static WeakListPasswordValidator build() {
        
        ClassLoader loader = WeakListPasswordValidator.class.getClassLoader();

        try (Reader reader = new InputStreamReader(loader.getResourceAsStream(FILE_NAME))) {
            return new Gson().fromJson(reader, WeakListPasswordValidator.class);
        } catch (IOException e) {
            return new WeakListPasswordValidator(new TreeSet<String>());            
        }
    }
}
