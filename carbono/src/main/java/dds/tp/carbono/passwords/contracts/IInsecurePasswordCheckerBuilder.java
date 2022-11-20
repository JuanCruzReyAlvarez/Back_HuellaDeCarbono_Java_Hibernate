package dds.tp.carbono.passwords.contracts;

import dds.tp.carbono.passwords.checker.InsecurePasswordChecker;
import dds.tp.carbono.passwords.checker.validators.ValidatorType;

public interface IInsecurePasswordCheckerBuilder {
    InsecurePasswordChecker buildPasswordChecker(ValidatorType ...types);
}
