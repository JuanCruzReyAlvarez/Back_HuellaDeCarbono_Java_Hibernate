package dds.tp.carbono.repository;

import java.util.List;

public abstract class Repository<T> {

    private List<T> lista;

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
