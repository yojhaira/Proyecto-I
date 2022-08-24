package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Customer;
import pe.com.projectbanco.ProyectoI.model.Personal;
import pe.com.projectbanco.ProyectoI.repo.ICustomerRepo;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerServiceImpl implements ICustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public Mono<Customer> create(Customer obj) {
        logger.info(" Request Body: "+ obj);
        return iCustomerRepo.save(obj);
    }

    @Override
    public Mono<Customer> update(Customer obj) {
        return iCustomerRepo.save(obj);
    }

    @Override
    public Flux<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Mono<Customer> listPorId(String id) {
        Mono<Customer> op = iCustomerRepo.findById(id);
        return op;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }


    @Override
    public Mono<Void> delete(Customer customer) {
       return iCustomerRepo.delete(customer);

    }

}
