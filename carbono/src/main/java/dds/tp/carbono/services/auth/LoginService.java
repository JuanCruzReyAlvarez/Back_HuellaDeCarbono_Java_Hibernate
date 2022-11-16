package dds.tp.carbono.services.auth;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.http.utils.SessionCookie;
import dds.tp.carbono.repository.auth.UsuarioRepository;

public class LoginService {

    private UsuarioRepository repository;

    public LoginService() {
        this.repository = new UsuarioRepository();
    }

    public SessionCookie login(String username, String password) throws Exception {

        if (!this.repository.isValidLogin(username, password))
            throw new Exception("Unauthorized, Contraseña Incorrecta");   

        Usuario usuario = new Usuario();
        usuario = this.repository.getUsuarioByUsername(username);  


        System.out.println(usuario.getUsername());
        System.out.println(usuario.getPassword());

        return new SessionCookie(usuario);
    }
}