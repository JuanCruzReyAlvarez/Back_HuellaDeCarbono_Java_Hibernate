package dds.tp.carbono.services.auth;

import dds.tp.carbono.builder.InsecurePasswordCheckerBuilder;
import dds.tp.carbono.checker.InsecurePasswordChecker;
import dds.tp.carbono.contracts.IInsecurePasswordCheckerBuilder;
import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.exception.InsecurePasswordException;
import dds.tp.carbono.repository.auth.UsuarioRepository;

public class RegisterService {

    private IInsecurePasswordCheckerBuilder passwordCheckerBuilder;
    private UsuarioRepository repository;

    public RegisterService(InsecurePasswordCheckerBuilder passwordCheckerBuilder) {
        this.passwordCheckerBuilder = passwordCheckerBuilder;
        this.repository = new UsuarioRepository();
    }

    public Usuario register(String username, String password, String rol) throws InsecurePasswordException {
        InsecurePasswordChecker checker = passwordCheckerBuilder.buildPasswordChecker();

        if (!checker.isSecure(password))
            throw new InsecurePasswordException();
        System.out.println("papa");
        Usuario usuario = this.buildUsuario(username, password, rol);
        return this.repository.guardar(usuario);
    }

    private Usuario buildUsuario(String username, String password, String rol) {
        Usuario usuario = new Usuario();
        usuario.setHashPassword(password);
        usuario.setUsername(username);
        usuario.setRol(Rol.valueOf(rol.toUpperCase()));
        return usuario;
    } 
}
