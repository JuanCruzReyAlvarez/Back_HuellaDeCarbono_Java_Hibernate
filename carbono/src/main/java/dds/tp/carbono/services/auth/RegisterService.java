package dds.tp.carbono.services.auth;


import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
//import dds.tp.carbono.passwords.checker.InsecurePasswordChecker;
//import dds.tp.carbono.passwords.contracts.IInsecurePasswordCheckerBuilder;
import dds.tp.carbono.repository.auth.UsuarioRepository;

public class RegisterService {

    //private IInsecurePasswordCheckerBuilder passwordCheckerBuilder;
    private UsuarioRepository repository;

    public RegisterService() {
       // this.passwordCheckerBuilder = passwordCheckerBuilder;
        this.repository = new UsuarioRepository();
    }

    public Usuario register(String username, String password, String rol) throws Exception {
        //InsecurePasswordChecker checker = passwordCheckerBuilder.buildPasswordChecker();
        //if (checker.isSecure(password))
        //    throw new Exception();
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
