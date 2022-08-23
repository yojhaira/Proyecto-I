package pe.com.projectbanco.ProyectoI.service;

import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Customer;
import reactor.core.publisher.Flux;

public interface ICustomerService extends ICRUD<Customer, Integer> {

    @Query("{'idCustomer':?0}")
    Flux<Customer> findByIdCustomer(String idCustomer);
}
