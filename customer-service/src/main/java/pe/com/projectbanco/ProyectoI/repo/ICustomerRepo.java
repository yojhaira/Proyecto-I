package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.projectbanco.ProyectoI.model.Customer;
import reactor.core.publisher.Flux;

@Repository
public interface ICustomerRepo extends ReactiveMongoRepository<Customer,Integer> {



}
