package dds.tp.carbono.contracts.services.auth;

import dds.tp.carbono.contracts.IoC.Injectable;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.exception.InsecurePasswordException;

public interface IRegisterService extends Injectable {
    Usuario register(String username, String password, String rol) throws InsecurePasswordException;
}
