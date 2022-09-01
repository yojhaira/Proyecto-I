package pe.com.projectbanco.ProyectoI.service;

import org.springframework.data.mongodb.repository.Query;
import pe.com.projectbanco.ProyectoI.model.Product;
import reactor.core.publisher.Flux;

public interface IProductrService extends ICRUD<Product, String> {
    @Query("{'id':?0}")
    Flux<Product> findByIdProduct(String idProduct);



}
