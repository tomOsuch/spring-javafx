package pl.tomaszosuch.personlistapi.service;

import java.util.List;

public interface GenericService<T extends Object> {

    T findById(Long id);
    List<T> findAll();
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    void deleteById(Long id);
}
