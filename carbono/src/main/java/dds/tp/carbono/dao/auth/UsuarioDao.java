package dds.tp.carbono.dao.auth;

import dds.tp.carbono.dao.member.Dao;
import dds.tp.carbono.entities.auth.Usuario;

public class UsuarioDao extends Dao<Usuario> {

    private static UsuarioDao instance;

    public static UsuarioDao getInstance() {
        if (instance == null)
            instance = new UsuarioDao();
        return instance;
    }

    @Override
    public Usuario setId(Integer id, Usuario item) {
        item.setId(id);
        return item;
    }    
}
