package dds.tp.carbono.services.auth;

import dds.tp.carbono.checker.InsecurePasswordChecker;
import dds.tp.carbono.contracts.IInsecurePasswordCheckerBuilder;
import dds.tp.carbono.contracts.services.auth.IRegisterService;
import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.exception.InsecurePasswordException;

public class RegisterService implements IRegisterService {

    private IInsecurePasswordCheckerBuilder passwordCheckerBuilder;

    public RegisterService(IInsecurePasswordCheckerBuilder passwordCheckerBuilder) {
        this.passwordCheckerBuilder = passwordCheckerBuilder;
    }

    @Override
    public Usuario register(String username, String password, String rol) throws InsecurePasswordException {
        InsecurePasswordChecker checker = passwordCheckerBuilder.buildPasswordChecker();

        if (!checker.isSecure(password))
            throw new InsecurePasswordException();
        
        return this.buildUsuario(username, password, rol) ;
    }

    private Usuario buildUsuario(String username, String password, String rol) {
        Usuario usuario = new Usuario();
        usuario.setPassword(password);
        usuario.setUsername(username);
        usuario.setRol(Rol.valueOf(rol.toUpperCase()));
        return usuario;
    } 
}
