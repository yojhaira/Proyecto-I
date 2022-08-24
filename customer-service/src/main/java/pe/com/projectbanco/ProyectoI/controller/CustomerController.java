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

    @GetMapping(value = "/findAll")

    public ResponseEntity<Flux<Customer>> findAll() {
        log.info("Start controllerCustomer method findAll");

       Flux<Customer> listCustomer = iCustomerService.findAll();
        return new ResponseEntity<>( listCustomer,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<Customer>> changeCustomer(@RequestBody Customer customer) {
        Mono<Customer> oCustomer = iCustomerService.update(customer);
        return new ResponseEntity<>(oCustomer, HttpStatus.CREATED);
    }
    @GetMapping("listById/{codCustomer}")
    public  ResponseEntity<Flux<Customer>> findByIdCustomer(@PathVariable("codCustomer") String idCustomer){
        Flux<Customer> oListCustomer = iCustomerService.findByIdCustomer(idCustomer);
        return new ResponseEntity<>(oListCustomer,HttpStatus.OK);
    }

    @DeleteMapping("/{codCustomer}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("codCustomer") Integer id) {
        Flux<Customer> oCustomer = iCustomerService.findById(id);
        iCustomerService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
