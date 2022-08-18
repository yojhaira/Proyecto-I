package pe.com.projectbanco.service;

import java.util.List;

public interface ICRUD<T, V> {

    T  create(T obj);
    T update(T obj);
    List<T> findAll();
    T listarPorId(V id);
    boolean delete(V id);
}