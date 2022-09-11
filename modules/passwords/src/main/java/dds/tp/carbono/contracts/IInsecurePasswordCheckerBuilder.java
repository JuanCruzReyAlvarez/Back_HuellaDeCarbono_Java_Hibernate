package dds.tp.carbono.contracts;

import dds.tp.carbono.checker.InsecurePasswordChecker;
import dds.tp.carbono.checker.validators.ValidatorType;

public interface IInsecurePasswordCheckerBuilder {
    InsecurePasswordChecker buildPasswordChecker(ValidatorType ...types);
}
