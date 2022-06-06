package dds.tp.carbono.services.auth;

import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.repository.auth.UsuarioRepository;

public class LoginService {

    private UsuarioRepository repository;

    public LoginService() {
        this.repository = new UsuarioRepository();
    }

    public Usuario login(String username, String password) throws Exception {
        if (this.repository.isValidLogin(username, password))
            return this.repository.getUsuarioByUsername(username);
        
        throw new Exception("Unauthorized");   
    }
}
