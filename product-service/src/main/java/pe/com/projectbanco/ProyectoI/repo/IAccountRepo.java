package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.com.projectbanco.ProyectoI.model.Account;

@Repository
public interface IAccountRepo extends ReactiveMongoRepository<Account,Integer> {

}
