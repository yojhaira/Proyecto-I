package pe.com.projectbanco.ProyectoI.service;

import pe.com.projectbanco.ProyectoI.model.Movement;
import reactor.core.publisher.Mono;

public interface IMovementService  extends ICRUD<Movement,String> {

   // Mono<Void> delete(Movement obj);
}
