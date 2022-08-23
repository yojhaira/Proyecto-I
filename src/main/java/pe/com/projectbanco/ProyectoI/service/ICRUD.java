package pe.com.projectbanco.ProyectoI.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICRUD<T, V> {

    Mono<T> create(T obj);

    Mono<T> update(T obj);

    Flux<T> findAll();

    Flux<T> findById(V id);

    Mono<Void> delete(T obj);

    Mono<Void> deleteById(V id);
}