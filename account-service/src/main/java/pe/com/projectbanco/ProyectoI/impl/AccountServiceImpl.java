package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.model.Customer;
import pe.com.projectbanco.ProyectoI.repo.IAccountRepo;
import pe.com.projectbanco.ProyectoI.repo.ICustomerRepo;
import pe.com.projectbanco.ProyectoI.service.IAccountService;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@Component
public class AccountServiceImpl implements IAccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private IAccountRepo iAccountRepo;

    @Override
    public Flux<Account> findByAccountByProduct(String nameTypeProduct) {
        return iAccountRepo.findAll().filter(p->p.getProduct().getNameProductType().equals(nameTypeProduct));

    }

    @Override
    public Flux<Account> findByIdCustomer(String idCustomer) {
        return null;
    }

    @Override
    public Flux<Account> findByNroDocument(String customerType) {
        return null;
    }

    @Override
    public Mono<Account> create(Account obj) {
        logger.info(" Request Body: "+ obj);
        return iAccountRepo.save(obj);
    }

    @Override
    public Mono<Account> update(Account obj) {
        return iAccountRepo.save(obj);
    }

    @Override
    public Flux<Account> findAll() {
        return iAccountRepo.findAll();
    }

    @Override
    public Mono<Account> listPorId(String id) {
        Mono<Account> op = iAccountRepo.findById(id);
        return op;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Void> delete(Account obj) {
        return iAccountRepo.delete(obj);
    }
}
