package dds.tp.carbono.services.auth;

import dds.tp.carbono.contracts.services.auth.ILoginService;
import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginService implements ILoginService {

    @Override
    public Usuario login(String username, String password) {
       
        log.info("Haciendo Log in");
        
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setRol(Rol.ADMINISTRADOR);
        
        return usuario;
    }
}
