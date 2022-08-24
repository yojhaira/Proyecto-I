package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    //private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private ICustomerService iCustomerService;

    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Customer>> createCustomer(@RequestBody Customer customer) {
        log.info("Start controllerCustomer method Create");
        Mono<Customer> oCustomer = iCustomerService.create(customer);
        return new ResponseEntity<>(oCustomer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Customer>> findAllCustomers() {
        log.info("Start controllerCustomer method findAll");
        Flux<Customer> listCustomer = iCustomerService.findAll();
        return new ResponseEntity<Flux<Customer>>(listCustomer, HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity<Mono<Customer>> changeCustomer(@RequestBody Customer customer) {
        log.info("Start controllerCustomer method change");
        Mono<Customer> p = iCustomerService.update(customer);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
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
    }
    @GetMapping("findByNroDoc/{nroOocument}")
    public  ResponseEntity<Flux<Customer>> findByNroDocument(@PathVariable("nroOocument") String nroOocument){
        log.info("Start controllerCustomer method findByIdCustomer =>", nroOocument);
        Flux<Customer> oListCustomer = iCustomerService.findByNroDocument(nroOocument).filter(p->p.isActive_s_n());
        return new ResponseEntity<>(oListCustomer,HttpStatus.OK);
    }
}
