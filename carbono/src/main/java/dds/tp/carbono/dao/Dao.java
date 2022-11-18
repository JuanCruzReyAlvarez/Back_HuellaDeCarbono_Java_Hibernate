package dds.tp.carbono.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;



public abstract class Dao<T> {

    private Class< T > clazz; 


    //private List<T> lista = new ArrayList<T>();
    //private int idCount = 0;

    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    public T save(T item) {
        System.out.println("Entro");
        EntityManagerHelper.beginTransaction();
        System.out.println("Entro");
        EntityManagerHelper.getEntityManager().persist(item);
        System.out.println("Entro");
        EntityManagerHelper.commit();
        System.out.println("Entro");
        EntityManagerHelper.closeEntityManager();

        return item;                                           
    }

    public void update(T item) {
        System.out.println("llegueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee11");
        EntityManagerHelper.beginTransaction();
        System.out.println("llegueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee22");
        
        EntityManagerHelper.getEntityManager().merge(item);
        System.out.println("llegueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee33");
        EntityManagerHelper.commit();
        System.out.println("llegueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee44");
        EntityManagerHelper.closeEntityManager();
        System.out.println("llegueeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee55");
        //return item1;
    }

    public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
        List<T> r = new ArrayList<T>(c.size());
        for(Object o: c)
          r.add(clazz.cast(o));
        return r;
    }

    public List<T> getAll() {
    
        CriteriaBuilder builder = EntityManagerHelper.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> criterios = builder.createQuery(this.clazz);
        criterios.from(clazz);
        List<T> entidades = EntityManagerHelper.getEntityManager().createQuery(criterios).getResultList();
                                                           
        return entidades;
    
    }

    public void saveAll(List<T> entities) {
        for(T entity: entities){ 
            save(entity);
        }
	}

    public void delete(T item) {
        EntityManagerHelper.beginTransaction(); 
        EntityManagerHelper.getEntityManager().remove(item);
        //EntityManagerHelper.closeEntityManager();
    } 

    public T findOne(Integer id ){
        return (T)EntityManagerHelper.getEntityManager().find( clazz, id );        
     }

    public void deleteById(Integer entityId ){
        
        EntityManagerHelper.beginTransaction();
        T entity = findOne( entityId );
        delete( entity );
        EntityManagerHelper.closeEntityManager();
     }

    //public abstract T setId(Integer id, T item);



}
