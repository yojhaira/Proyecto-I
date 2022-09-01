package pe.com.projectbanco.ProyectoI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.credit;
import pe.com.projectbanco.ProyectoI.service.IcreditService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/credit")
public class CreditController {

    private static final Logger logger = LoggerFactory.getLogger(CreditController.class);

    @Autowired
    private IcreditService icreditService;


    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<credit>> createBusiness(@RequestBody credit credit) {
        logger.info("{} {}", "Start Controller");
        Mono<credit> p = icreditService.create(credit);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }


    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<credit>> findAllCredit() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<credit> listcredit = icreditService.findAll();
        return new ResponseEntity<Flux<credit>>(listcredit, HttpStatus.OK);
    }


}
