package dds.tp.carbono.repository.auth;

import dds.tp.carbono.dao.auth.UsuarioDao;
import dds.tp.carbono.entities.auth.Usuario;

public class UsuarioRepository {
    private UsuarioDao dao;

    public UsuarioRepository() {
        this.dao = UsuarioDao.getInstance();
    }
    
    public Usuario guardar(Usuario usuario) {
        return this.dao.save(usuario);
    }

    public boolean isValidLogin(String username, String password) {
        return this.dao.getAll()
                        .stream()
                        .anyMatch(usuario -> usuario.getUsername().equals(username) 
                               && usuario.getPassword().equals(password));
    }

    public Usuario getUsuarioByUsername(String username) {
        return this.dao.getAll()
                       .stream()
                       .filter(usuario -> usuario.getUsername().equals(username))
                       .findFirst()
                       .orElseThrow();
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return this.dao.save(usuario);
    }
}
