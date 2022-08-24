package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.model.Customer;


public interface IAccountRepo extends ReactiveMongoRepository<Account,String> {



}
