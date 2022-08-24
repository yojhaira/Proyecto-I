package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Product;
import pe.com.projectbanco.ProyectoI.service.IProductrService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {
    //private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private IProductrService iProductrService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Product>> createProduct(@RequestBody Product product) {
        log.info("Start controllerProduct method Create");
        Mono<Product> oProduct = iProductrService.create(product);
        return new ResponseEntity<>(oProduct, HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Product>> findAllProducts() {
        log.info("Start controllerCustomer method findAll");
        Flux<Product> listProduct = iProductrService.findAll();
        return new ResponseEntity<Flux<Product>>(listProduct, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Mono<Product>> changeProduct(@RequestBody Product product) {
        log.info("Start controllerProduct method change");
        Mono<Product> p = iProductrService.update(product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

  /*  @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String codCustomer) {
        log.info("Start controllerCustomer method change Delete =>", codCustomer);
        Mono<Customer> p = iCustomerService.listPorId(codCustomer);
        iCustomerService.deleteById(codCustomer);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("findById/{codCustomer}")
    public  ResponseEntity<Mono<Customer>> findByIdCustomer(@PathVariable("codCustomer") String codCustomer){
        log.info("Start controllerCustomer method findByIdCustomer =>", codCustomer);
        Mono<Customer> oListCustomer = iCustomerService.listPorId(codCustomer);
        return new ResponseEntity<>(oListCustomer,HttpStatus.OK);
    }*/
    @GetMapping("findByNroDoc/{nameProduct}")
    public  ResponseEntity<Flux<Product>> findByNameProduct(@PathVariable("nameProduct") String nameProduct){
        log.info("Start controllerCustomer method findByNameProduct =>", nameProduct);
        Flux<Product> oListCustomer = iProductrService.findByNameProduct(nameProduct);
        return new ResponseEntity<>(oListCustomer,HttpStatus.OK);
    }

    @DeleteMapping("delete/{codProduct}")
    public Flux<ResponseEntity<Void>> deleteBusiness(@PathVariable("codProduct") String codProduct)
    {
        return iProductrService.findByCodProduct(codProduct).flatMap(p -> {
            return iProductrService.delete(p).then(Mono.just( new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }



}
