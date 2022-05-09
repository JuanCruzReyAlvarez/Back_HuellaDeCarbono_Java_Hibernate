package dds.tp.carbono.contracts;

import dds.tp.carbono.checker.InsecurePasswordChecker;
import dds.tp.carbono.checker.validators.ValidatorType;
import dds.tp.carbono.contracts.IoC.Injectable;

public interface IInsecurePasswordCheckerBuilder extends Injectable {
    InsecurePasswordChecker buildPasswordChecker(ValidatorType ...types);
}
