package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Customer;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Customer>> createCustomer(@RequestBody Customer customer) {
        log.info("{} {}", "Start controllerCustomer method Create");
        Mono<Customer> oCustomer = iCustomerService.create(customer);
        return new ResponseEntity<>(oCustomer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAll", produces = "application/json")

    public ResponseEntity<Flux<Customer>> findAllCustomers() {
        log.info("{} {}", "Start controllerCustomer method findAll");
        Flux<Customer> listCustomer = iCustomerService.findAll();
        return new ResponseEntity<Flux<Customer>>(listCustomer, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<Customer>> changeCustomer(@RequestBody Customer customer) {
        Mono<Customer> oCustomer = iCustomerService.update(customer);
        return new ResponseEntity<>(oCustomer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Integer id) {
        iCustomerService.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }
}
