package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @DeleteMapping("delete/{codCustomer}")
    public Flux<ResponseEntity<Void>> deleteCustomer(@PathVariable("codCustomer") String codCustomer) {
        log.info("Start controllerCustomer method change Delete =>", codCustomer);
       return iCustomerService.findByIdCustomer(codCustomer).flatMap(res -> {
            return iCustomerService.delete(res).then(Mono.just( new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("findById/{codCustomer}")
    public Flux<ResponseEntity<Customer>> findByIdCustomer(@PathVariable("codCustomer") String codCustomer){
        log.info("Start controllerCustomer method findByIdCustomer =>", codCustomer);
        return iCustomerService.findByIdCustomer(codCustomer)
                .map(res-> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(res))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("findByNroDoc/{nroOocument}")
    public  ResponseEntity<Flux<Customer>> findByNroDocument(@PathVariable("nroOocument") String nroOocument){
        log.info("Start controllerCustomer method findByIdCustomer =>", nroOocument);
        Flux<Customer> oListCustomer = iCustomerService.findByNroDocument(nroOocument).filter(p->p.isActive_s_n());
        return new ResponseEntity<>(oListCustomer,HttpStatus.OK);
    }
}