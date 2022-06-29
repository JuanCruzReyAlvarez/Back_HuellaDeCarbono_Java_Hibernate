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
            throw new Exception("Unauthorized");   
        
        Usuario usuario = this.repository.getUsuarioByUsername(username);
        return new SessionCookie(usuario);
    }
}
