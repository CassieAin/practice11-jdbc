package dao;

import java.util.List;

public interface EntityDao<T> {

    int create(T object);

    int delete(int key);

    List<T> getAll();
}
