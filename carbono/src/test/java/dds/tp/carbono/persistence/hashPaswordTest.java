package dds.tp.carbono.persistence;

import java.util.List;




import org.junit.Test;


import dds.tp.carbono.entities.auth.Rol;
import dds.tp.carbono.entities.auth.Usuario;
import dds.tp.carbono.repository.PuntoGeografico.ProvinciaRepository;
import dds.tp.carbono.repository.auth.UsuarioRepository;
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

        //ProvinciaDao dao = new ProvinciaDao();
        
        List<Provincia> prov = repository.getAll();

       // Provincia p = dao.


        
        /* 
        Session session = entityManager.getSessionFactory().getCurrentSession();

        List<Provincia> provicnia = entityManager.createNativeQuery( "SELECT * FROM " + table + " ORDER BY REV", Tuple.class ).getResultList();

        List<Provincia> provincias = entityManager().
                                    createQuery("from provincia",Provincia.class).
                                    getResultList().stream().collect((Collectors.toList()));
        */
        //(List<Provincia>) ((Collection<Provincia>) EntityManagerHelper.entityManager().createQuery("from Provincia",Provincia.class).getResultList()).stream()
        //for(Organizacion p : prov)
        //{
        //    System.out.println(p.getRazonSocial() + " PROVINCIA IMPRESAAA"); 
        //} 

       
                  
        
    }
    

    /**
    
insert into tp_huella_carbono.organizacion (clasificacion,razon_social,tipo)
values("monetaria","organizacion1","gubernamental" )
    
     */
    
}
