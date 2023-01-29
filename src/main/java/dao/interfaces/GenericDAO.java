package dao.interfaces;

import enums.Level;

import java.util.List;

public interface GenericDAO<T,S> {

    public void close();

    public T create(T entity);

    public T findByIdAndLevel(int id, S level);

    public T update(T entity);

    public void delete(T entity);

    public void deleteAll();

    public List<T> getAll();

}
