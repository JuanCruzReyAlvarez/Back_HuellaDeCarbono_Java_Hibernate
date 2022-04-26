package com.example.checker.validators.builder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.TreeSet;

import com.example.checker.validators.WeakListPasswordValidator;
import com.google.gson.Gson;

public class WeakListPasswordValidatorBuilder {

    private static String FILE_NAME = "src/main/resources/insecurePasswords.json";
    
    public static WeakListPasswordValidator build() {
        
        try (Reader reader = new FileReader(FILE_NAME)) {
            return new Gson().fromJson(reader, WeakListPasswordValidator.class);
        } catch (IOException e) {
            return new WeakListPasswordValidator(new TreeSet<String>());            
        }
    }
}
