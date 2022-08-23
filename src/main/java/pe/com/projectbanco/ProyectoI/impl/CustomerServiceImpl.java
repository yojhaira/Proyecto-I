package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Customer;
import pe.com.projectbanco.ProyectoI.repo.ICustomerRepo;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@Component
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
        logger.info(" Request Body: "+ obj);
        return iCustomerRepo.save(obj);
    }

    @Override
    public Flux<Customer> findAll() {
        logger.info(" Request Body: ");
        return iCustomerRepo.findAll();
    }

    @Override
    public Mono<Customer> findById(Integer id) {
        logger.info(" Request Body: "+ id);
        return iCustomerRepo.findById(id);//op.isPresent() ? op.get() : new Customer();
    }

    @Override
    public Mono<Void> delete(Customer oCustomer) {
        logger.info(" Request Body: "+ oCustomer);
        return iCustomerRepo.delete(oCustomer);
    }

    @Override
    public Mono<Void> deleteById(Integer id) {
        logger.info(" Request Body: "+ id);
         iCustomerRepo.deleteById(id).subscribe();
        return null;
    }

}
