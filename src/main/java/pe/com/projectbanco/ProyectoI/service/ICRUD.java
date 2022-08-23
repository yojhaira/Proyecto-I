package pe.com.projectbanco.ProyectoI.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ICRUD<T, V> {

   Mono<T> create(T obj);
    Mono<T> update(T obj);
    Flux<T> findAll();
    Mono<T> findById(V id);
    Mono<Void> deleteById(V id);
}