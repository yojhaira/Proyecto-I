package pe.com.projectbanco.ProyectoI.service;

import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomerService extends ICRUD<Customer, String> {
    @Query("{'customerType':?0}")
    Flux<Customer> findByTypeCustomer(String customerType);
    @Query("{'idCustomer':?0}")
    Flux<Customer> findByIdCustomer(String idCustomer);
    @Query("{'nroDocument':?0}")
    Flux<Customer> findByNroDocument(String customerType);

}
