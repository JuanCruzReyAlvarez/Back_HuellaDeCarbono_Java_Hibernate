package dds.tp.carbono.repository.auth;

import java.util.NoSuchElementException;

import dds.tp.carbono.dao.auth.UsuarioDao;
import dds.tp.carbono.entities.auth.Usuario;


public class UsuarioRepository {
    private UsuarioDao dao;

    public UsuarioRepository() {
        this.dao = UsuarioDao.getInstance();
        this.dao.setClazz(Usuario.class);
    } 
    
    public boolean isValidLogin(String username, String password) {
        return this.dao.getAll()
                        .stream()
                        .anyMatch(usuario -> usuario.getUsername().equals(username) 
                               && usuario.getPassword().equals(password));
    }

    public Usuario getUsuarioById(Integer id){
        return this.dao.findOne(id);
    }

     
    public Usuario getUsuarioByUsername(String username) throws NoSuchElementException {
        Usuario usuarioEncontrado =  this.dao.getUsuarioByUsername(username);
                                             
        if (usuarioEncontrado != null)
            return usuarioEncontrado;

        throw new NoSuchElementException();
    }
    
    public Usuario guardar(Usuario usuario) {
        return this.dao.save(usuario);
    }

    public void eliminar(Usuario usuario){
        this.dao.delete(usuario);;
    }
}
