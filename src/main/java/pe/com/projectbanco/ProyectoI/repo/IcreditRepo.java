package pe.com.projectbanco.ProyectoI.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.com.projectbanco.ProyectoI.model.credit;

public interface IcreditRepo extends ReactiveMongoRepository<credit,String> {
}
