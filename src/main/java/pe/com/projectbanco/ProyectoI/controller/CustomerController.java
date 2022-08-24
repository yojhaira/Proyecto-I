package pe.com.projectbanco.ProyectoI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Customer;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Customer>> createCustomer(@RequestBody Customer customer) {
        logger.info("{} {}", "Start controllerCustomer method Create");
        Mono<Customer> oCustomer = iCustomerService.create(customer);
        return new ResponseEntity<>(oCustomer, HttpStatus.CREATED);
    }

   @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Customer>> findAllCustomers() {
        logger.info("{} {}", "Start controllerCustomer method findAllCustomer");
        Flux<Customer> listCustomer = iCustomerService.findAll();
        return new ResponseEntity<Flux<Customer>>(listCustomer, HttpStatus.OK);
    }

   @PutMapping
    public ResponseEntity<Mono<Customer>> changeCustomer(@RequestBody Customer customer) {
       Mono <Customer> p = iCustomerService.update(customer);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") String idPrueba) {
        logger.info("{} {}", "DeleteMapping =>" , idPrueba);
        Mono <Customer> p = iCustomerService.listPorId(idPrueba);

        iCustomerService.deleteById(idPrueba);
        return new ResponseEntity<Void> (HttpStatus.NO_CONTENT);
    }
}
