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
        
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(item);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

        return item;                                           
    }

    public T update(T item) {
        EntityManagerHelper.beginTransaction();
        T item1 =EntityManagerHelper.getEntityManager().merge( item );
        EntityManagerHelper.closeEntityManager();
        return item1;
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
        System.out.println("Entro a M ");
        
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
