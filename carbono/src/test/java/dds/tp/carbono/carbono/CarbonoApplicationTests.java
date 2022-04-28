package dds.tp.carbono.carbono;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import dds.tp.carbono.builder.InsecurePasswordCheckerBuilder;
import dds.tp.carbono.checker.InsecurePasswordChecker;

class CarbonoApplicationTests {

	@Test
    public void insecurePasswordsTest() {

        InsecurePasswordChecker checker = InsecurePasswordCheckerBuilder.getInstance().buildPasswordChecker();

        Assert.notNull(checker, "Checker shouldn't be null");

        String[] insecurePasswords = new String[] {
            "pcorta",         // Es muy corta
            "B4seball",       // Esta en la lista de passwords debiles
            "un4passs3gur4!", // No tiene Mayuscula
            "unapasssegura!", // No tiene Numeros
            "UNAPASSSEGURA!"  // No tiene Minuscula
        };

        Arrays.stream(insecurePasswords).forEach(insecurePassword ->
            Assert.isTrue(!checker.isSecure(insecurePassword), String.format("Password %s should Be Insecure", insecurePassword)));
    }
}
