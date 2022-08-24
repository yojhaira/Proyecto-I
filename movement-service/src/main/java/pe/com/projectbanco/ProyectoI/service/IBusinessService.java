package pe.com.projectbanco.ProyectoI.service;



import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Business;
import reactor.core.publisher.Flux;

public interface IBusinessService extends ICRUD<Business, String> {

    @Query("{'idBusiness':?0}")
    Flux<Business> findByIdBusiness(String idBusiness);
    @Query("{'ruc':?0}")
    Flux<Business> findByRUC(String ruc);

}
