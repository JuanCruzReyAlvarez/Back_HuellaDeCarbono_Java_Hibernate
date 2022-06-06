package dds.tp.carbono.services.auth;

import dds.tp.carbono.contracts.services.auth.ILoginService;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.repository.auth.UsuarioRepository;


public class LoginService implements ILoginService {

    private UsuarioRepository repository;

    public LoginService() {

        this.repository = new UsuarioRepository();
    }

    @Override
    public Usuario login(String username, String password) {

        if (this.repository.isValidLogin(username, password))
            return this.repository.getUsuarioByUsername(username);
        
        return null;   
    }
}
