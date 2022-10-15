package dds.tp.carbono.dao.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import dds.tp.carbono.dao.EntityManagerHelper;


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

        return item;                                                //chekiar
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
        List<T> lista = castList(clazz, EntityManagerHelper.getEntityManager()
                                                           .createQuery( "from " + clazz.getName() )
                                                           .getResultList());
        return lista;
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
