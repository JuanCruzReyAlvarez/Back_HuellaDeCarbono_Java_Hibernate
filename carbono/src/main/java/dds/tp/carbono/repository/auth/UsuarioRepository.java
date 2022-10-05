package dds.tp.carbono.repository.auth;

import java.util.NoSuchElementException;



import dds.tp.carbono.dao.auth.UsuarioDao;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.services.seguridad.Hash;



public class UsuarioRepository {
    private UsuarioDao dao;

    public UsuarioRepository() {
        this.dao = UsuarioDao.getInstance();
        this.dao.setClazz(Usuario.class);
    } 
    


    public boolean isValidLogin(String username, String password) { 
        //hashear aca password 
        Hash hash = new Hash();
        String hashPassword = hash.setHashPassword(password);

        Usuario user = this.getUsuarioByUsername(username);
       
        return user.getUsername().equals(username) && user.getPassword().equals(hashPassword); //hasheada 
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
/*
    public Usuario getUsuarioByContraseña(String contraseña) throws NoSuchElementException {
        Usuario usuarioEncontrado =  this.dao.getUsuarioByContraseña(contraseña);
                                             
        if (usuarioEncontrado != null)
            return usuarioEncontrado;

        throw new NoSuchElementException();
    }
     */
    public Usuario guardar(Usuario usuario) {
        return this.dao.save(usuario);
    }

    public void eliminar(Usuario usuario){
        this.dao.delete(usuario);;
    }
}
