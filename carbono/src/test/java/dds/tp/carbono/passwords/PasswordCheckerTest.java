package dds.tp.carbono.passwords;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import dds.tp.carbono.passwords.builder.InsecurePasswordCheckerBuilder;
import dds.tp.carbono.passwords.checker.InsecurePasswordChecker;
import dds.tp.carbono.passwords.checker.validators.ValidatorType;



public class PasswordCheckerTest {

    @Test
    public void insecurePasswordsTest() {

        InsecurePasswordChecker checker = new InsecurePasswordCheckerBuilder().buildPasswordChecker();

        Assert.assertNotNull(checker);

        String[] insecurePasswords = new String[] {
            "pcorta",         // Es muy corta
            "B4seball",       // Esta en la lista de passwords debiles
            "un4passs3gur4!", // No tiene Mayuscula
            "unapasssegura!", // No tiene Numeros
            "UNAPASSSEGURA!"  // No tiene Minuscula
        };

        Arrays.stream(insecurePasswords).forEach(insecurePassword ->
        {
            Assert.assertFalse(checker.isSecure(insecurePassword));
        });
    }

    @Test
    public void securePasswordsTest() {

        InsecurePasswordChecker checker = new InsecurePasswordCheckerBuilder().buildPasswordChecker();

        Assert.assertNotNull(checker);

        Arrays.stream(new String[] { 
            "un4passS3gur4!", 
            "LaCat3dtaDDS!", 
            "UtnFRB4Medrano", 
            "L4CdeTuMAllb0ys" 
        })
        .forEach(password -> Assert.assertTrue(checker.isSecure(password)));
    }


    @Test
    public void securePasswordTestOnlyLength() {

        InsecurePasswordChecker checker = new InsecurePasswordCheckerBuilder().buildPasswordChecker(ValidatorType.LENGTH);

        Assert.assertNotNull(checker);

        Arrays.stream(new String[] { 
            "unapasssegura!", 
            "LACAT3DTADDS!", 
            "1234567898", 
            "asdasdasdads" 
        })
        .forEach(password -> Assert.assertTrue(checker.isSecure(password)));

        Arrays.stream(new String[] { 
            "un4pass", 
            "1234567", 
            "Asdasdd", 
            "123" 
        })
        .forEach(password -> Assert.assertFalse(checker.isSecure(password)));
    }

    @Test
    public void securePasswordTestOnlyLengthAndUpper() {

        ValidatorType[] myValidators = new ValidatorType[] { 
            ValidatorType.LENGTH, 
            ValidatorType.UPPERCASE
        };
        
        InsecurePasswordChecker checker = new InsecurePasswordCheckerBuilder().buildPasswordChecker(myValidators);

        Assert.assertNotNull(checker);

        Arrays.stream(new String[] { 
            "LACAT3DTADDS!", 
            "1234567898AAA",
            "ASDASD123" 
        })
        .forEach(password -> Assert.assertTrue(checker.isSecure(password)));

        Arrays.stream(new String[] { 
            "un4pass", 
            "1234567", 
            "AsdASD", 
            "123",
            "123asdasdasd",
        })
        .forEach(password -> Assert.assertFalse(checker.isSecure(password)));
    }
}
