package pe.com.projectbanco.ProyectoI.service;

import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.model.Customer;
import reactor.core.publisher.Flux;

public interface IAccountService  extends ICRUD<Account,String> {
    @Query("{'nameProductType':?0}")
    Flux<Account> findByAccountByProduct(String nameTypeProduct);
    @Query("{'idCustomer':?0}")
    Flux<Account> findByIdCustomer(String idCustomer);
    @Query("{'nroDocument':?0}")
    Flux<Account> findByNroDocument(String customerType);
}
