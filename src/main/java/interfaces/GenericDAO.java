package interfaces;

import enums.Level;

import java.util.List;

public interface GenericDAO<T> {

    public void close();

    public T create(T entity);

    public T findByIdAndLevel(int id, Level level);

    public T update(T entity);

    public void delete(T entity);

    public void deleteAll();

    public List<T> getAll();

}
