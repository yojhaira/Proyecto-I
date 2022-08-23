package pe.com.projectbanco.ProyectoI.impl;

import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.service.IAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements IAccountService {
    @Override
    public Mono<Account> create(Account obj) {
        return null;
    }

    @Override
    public Mono<Account> update(Account obj) {
        return null;
    }

    @Override
    public Flux<Account> findAll() {
        return null;
    }

    @Override
    public Flux<Account> findById(Integer id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Account obj) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        return null;
    }
}
