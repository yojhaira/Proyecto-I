package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.model.Customer;
import pe.com.projectbanco.ProyectoI.service.IAccountService;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @Autowired
    private ICustomerService iCustomerService;
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Account>> createCustomer(@RequestBody Integer idCustomer, Account account) {
        log.info("{} {}", "Start controllerAccount method Create");

        Flux<Customer> oCustomer = iCustomerService.findById(idCustomer);

        Mono<Account> oAccount = iAccountService.create(account);

        return new ResponseEntity<Mono<Account>>(oAccount, HttpStatus.CREATED);
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

    /*@DeleteMapping("/{codCustomer}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("codCustomer") Integer id) {
        iCustomerService.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }*/
    @DeleteMapping("/{codCustomer}")
    public ResponseEntity<Void> deleteMovement(@PathVariable("codCustomer") Integer id) {
        Flux<Customer> oCustomer = iCustomerService.findById(id);
        iCustomerService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
