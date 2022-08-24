package pe.com.projectbanco.ProyectoI.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.ProyectoI.model.Product;
import pe.com.projectbanco.ProyectoI.repo.IProductRepo;
import pe.com.projectbanco.ProyectoI.service.IProductrService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@Component
public class ProductServiceImpl implements IProductrService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private IProductRepo iProductRepo;
    @Override
    public Mono<Product> create(Product obj) {
        logger.info(" Request Body: "+ obj);
        return iProductRepo.save(obj);
    }

    @Override
    public Mono<Product> update(Product obj) {
        return iProductRepo.save(obj);
    }

    @Override
    public Flux<Product> findAll() {
        return iProductRepo.findAll();
    }

    @Override
    public Mono<Product> listPorId(String id) {
        Mono<Product> op = iProductRepo.findById(id);
        return op;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }


    @Override
    public Mono<Void> delete(Product product) {
        return iProductRepo.delete(product);

    }

    @Override
    public Flux<Product> findByNameProduct(String nameProduct) {
        return iProductRepo.findAll().filter(p->p.getNameProduct().equals(nameProduct));

    }
}
