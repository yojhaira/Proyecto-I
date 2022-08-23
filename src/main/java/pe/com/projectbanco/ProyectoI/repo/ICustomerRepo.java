package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.projectbanco.ProyectoI.model.Customer;

@Repository
public interface ICustomerRepo extends ReactiveMongoRepository<Customer,Integer> {


}
