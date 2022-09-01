package pe.com.projectbanco.ProyectoI.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pe.com.projectbanco.ProyectoI.model.currentAccount;
import pe.com.projectbanco.ProyectoI.repo.ICurrentAccountRepo;
import pe.com.projectbanco.ProyectoI.service.ICurrentAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CurrentAccountImpl implements ICurrentAccountService {

    @Autowired
    private ICurrentAccountRepo iCurrentAccountRepo;

    @Override
    public Mono<currentAccount> create(currentAccount obj) {
        return iCurrentAccountRepo.save(obj);
    }

    @Override
    public Mono<currentAccount> update(currentAccount obj) {
        return null;
    }

    @Override
    public Flux<currentAccount> findAll() {
        return null;
    }

    @Override
    public Mono<currentAccount> listPorId(String id) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Void> delete(currentAccount obj) {
        return null;
    }
}
