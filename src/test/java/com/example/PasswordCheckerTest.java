package com.example;

import java.util.Arrays;

import com.example.factory.InsecurePasswordCheckerFactory;
import com.example.utils.InsecurePasswordChecker;

import org.junit.Assert;
import org.junit.Test;

public class PasswordCheckerTest {

    @Test
    public void insecurePasswordsTest() {

        InsecurePasswordChecker checker = InsecurePasswordCheckerFactory.makeCheckerFromJsonFile();

        Assert.assertNotNull(checker);

        String[] insecurePasswords = new String[] {
            "pcorta",         // Es muy corta
            "B4seball",       // Esta en la lista de passwords debiles
            "un4passs3gur4!", // No tiene Mayuscula
            "unapasssegura!", // No tiene Numeros
            "UNAPASSSEGURA!"  // No tiene Minuscula
        };

        Arrays.stream(insecurePasswords).forEach(insecurePassword ->
            Assert.assertFalse(checker.isSecure(insecurePassword)));
    }

    @Test
    public void securePasswordsTest() {

        InsecurePasswordChecker checker = InsecurePasswordCheckerFactory.makeCheckerFromJsonFile();

        Assert.assertNotNull(checker);

        Arrays.stream(new String[] { 
            "un4passS3gur4!", 
            "LaCat3dtaDDS!", 
            "UtnFRB4Medrano", 
            "L4CdeTuMAllb0ys" 
        })
        .forEach(password -> Assert.assertTrue(checker.isSecure(password)));
    }
}
