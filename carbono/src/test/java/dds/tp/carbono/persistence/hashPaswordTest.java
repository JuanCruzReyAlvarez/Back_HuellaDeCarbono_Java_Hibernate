package dds.tp.carbono.persistence;

import java.util.List;


import org.junit.Test;

import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.entities.member.Miembro;
import dds.tp.carbono.repository.PuntoGeografico.ProvinciaRepository;
import dds.tp.carbono.repository.auth.UsuarioRepository;
import dds.tp.carbono.repository.member.MiembroRepository;
import dds.tp.carbono.services.external.dto.Provincia;






//import javax.persistence.EntityManager.createNativeQuery;

public class hashPaswordTest {


    @Test
    public void guardarConstraseñaHasheada(){
        Usuario user = new Usuario();
        UsuarioRepository repository = new UsuarioRepository();

        user.setUsername("Jero");
        user.setRol(Rol.ADMINISTRADOR);
        user.setHashPassword("stephy");

        repository.guardar(user);
    }


 
    @Test
    public void getOrg(){

            
        ProvinciaRepository repository = new ProvinciaRepository();
        List<Provincia> entidades = repository.getAll();
                  
        for(Provincia o :entidades ){
            System.out.println(o.getNombre());
        }

         
        
    }
    
}
