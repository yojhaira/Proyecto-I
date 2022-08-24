package pe.com.projectbanco.ProyectoI.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.ProyectoI.model.Movement;
import pe.com.projectbanco.ProyectoI.service.IMovementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/movement")
public class MovementController {
    private static final Logger logger = LoggerFactory.getLogger(MovementController.class);

    @Autowired
    private IMovementService iMovementService;

   @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Mono<Movement>> createMovement(@RequestBody Movement movement) {
        logger.info("{} {}", "Start MovementController");
        Mono<Movement> oMovement = iMovementService.create(movement);
        return new ResponseEntity<>(oMovement, HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAll", produces = "application/json")
    public ResponseEntity<Flux<Movement>> findAllMovimiento() {
        logger.info("{} {}", "Inicio metodo del controller");
        Flux<Movement> listMovement = iMovementService.findAll();
        return new ResponseEntity<Flux<Movement>>(listMovement, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Mono<Movement>> changeMovement(@RequestBody Movement movimiento) {
        Mono<Movement> oMovement = iMovementService.update(movimiento);
        return new ResponseEntity<>(oMovement, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovement(@PathVariable("id") String id)
    {
       Mono<Movement> oMovement = iMovementService.listPorId(id);
       //iMovementService.delete(id);
        return new  ResponseEntity<Void>(HttpStatus.NO_CONTENT); //ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    /*{
        return iMovementService.delete(id);

              /*  iMovementService.findById(id).flatMap(p ->{
            return iMovementService.delete(p).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));*/
    //}


}
