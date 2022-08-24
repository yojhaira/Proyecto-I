package pe.com.projectbanco.ProyectoI.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.projectbanco.ProyectoI.model.Account;
import pe.com.projectbanco.ProyectoI.model.Customer;
import pe.com.projectbanco.ProyectoI.service.IAccountService;
import pe.com.projectbanco.ProyectoI.service.ICustomerService;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private IAccountService iAccountService;
    @GetMapping("findByNroDoc/{nameProducType}")
    public ResponseEntity<Flux<Account>> findByNroDocument(@PathVariable("nameProducType") String nameProducType){
        log.info("Start controllerCustomer method findByIdCustomer =>", nameProducType);
        Flux<Account> oListCustomer = iAccountService.findByAccountByProduct(nameProducType);
        return new ResponseEntity<>(oListCustomer, HttpStatus.OK);
    }
}
