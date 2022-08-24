package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.service.IAccountService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @GetMapping("findByNroDoc/{nameProducType}")
    public ResponseEntity<Flux<Account>> findByAccountByProduct(@PathVariable("nameProducType") String nameProducType){
        log.info("Start controllerCustomer method findByNroDocument =>", nameProducType);
        Flux<Account> oListCustomer = iAccountService.findByAccountByProduct(nameProducType);
        return new ResponseEntity<>(oListCustomer, HttpStatus.OK);
    }
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Account>> createCustomer(@RequestBody Account account) {
        log.info("Start controllerAccount method Create");
        Mono<Account> oAccount = iAccountService.create(account);
        return new ResponseEntity<>(oAccount, HttpStatus.CREATED);
    }
}
