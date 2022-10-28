package dds.tp.carbono.dao.auth;

import dds.tp.carbono.dao.EntityManagerHelper;
import dds.tp.carbono.dao.Dao;
import dds.tp.carbono.entities.auth.Usuario;

public class UsuarioDao extends Dao<Usuario> {

    private static UsuarioDao instance;

    public static UsuarioDao getInstance() {
        if (instance == null)
            instance = new UsuarioDao();
        return instance;
    }

    public Usuario getUsuarioByUsername(String username) {
    
        return (Usuario) EntityManagerHelper
        .createQuery("from " + Usuario.class.getName() + " where username =" + "'" + username + "'")
        .getSingleResult();
    
    }

    
/* 
    public Usuario getUsuarioByContraseña(String contraseña) {
        Usuario prueba =  (Usuario) EntityManagerHelper
        .createQuery("from " + Usuario.class.getName() + " where password =" + "'" + contraseña + "'")
        .getSingleResult();
        System.out.println(" HHHHHHHHHHHHOOOOOOOOOOOOOOOLLLLLLLLLLLLLLLAAAAAAAAAAAAAAAAA");
        System.out.println(prueba.getUsername());
        return prueba;
       
    }
*/
    //@Override
    //public Usuario setId(Integer id, Usuario item) {
       // item.setId(id);
        //return item;
    //}    

}
