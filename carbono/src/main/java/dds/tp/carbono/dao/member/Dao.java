package dds.tp.carbono.dao.member;

import java.util.ArrayList;
import java.util.List;

public abstract class Dao<T> {

    private List<T> lista = new ArrayList<T>();

    public T save(T item) {
        this.setId(this.lista.size() + 1, item);        
        this.lista.add(item);
        return item;
    }

    public List<T> getAll() {
        return this.lista;
    }

    public void delete(T item) {

    } 

    public abstract T setId(Integer id, T item);
}
