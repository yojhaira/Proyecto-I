package pe.com.projectbanco.ProyectoI.impl;

import pe.com.projectbanco.ProyectoI.model.credit;
import pe.com.projectbanco.ProyectoI.service.IcreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class creditServiceImpl implements IcreditService {
    @Override
    public Mono<credit> create(credit obj) {
        return null;
    }

    @Override
    public Mono<credit> update(credit obj) {
        return null;
    }

    @Override
    public Flux<credit> findAll() {
        return null;
    }

    @Override
    public Mono<credit> listPorId(String id) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Void> delete(credit obj) {
        return null;
    }
}
