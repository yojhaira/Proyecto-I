package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.repo.AccountRepo;
import pe.com.projectbanco.ProyectoI.service.AccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AccountServiceImpl  implements AccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepo IaccountRepo;

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
    public Mono<Account> listPorId(String id) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Account obj) {
        return null;
    }
}
