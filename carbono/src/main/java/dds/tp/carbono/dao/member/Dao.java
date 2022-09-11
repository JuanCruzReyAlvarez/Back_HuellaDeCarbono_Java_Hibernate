package dds.tp.carbono.dao.member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Dao<T> {

    private List<T> lista = new ArrayList<T>();
    private int idCount = 0;

    public T save(T item) {
        this.setId(++this.idCount, item);        
        this.lista.add(item);
        return item;
    }

    public T update(T item) {
        int index = this.lista.indexOf(item);        
        this.lista.set(index, item);
        return item;
    }

    public List<T> getAll() {
        return this.lista;
    }

    public void delete(T item) {
        this.lista = this.lista.stream()
                               .filter(i -> !i.equals(item))
                               .collect(Collectors.toList());
    } 

    public abstract T setId(Integer id, T item);
}
