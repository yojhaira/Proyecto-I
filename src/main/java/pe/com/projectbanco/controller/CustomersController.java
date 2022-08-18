package pe.com.projectbanco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.com.projectbanco.config.PropertiesExternas;
import pe.com.projectbanco.entity.Customer;
import pe.com.projectbanco.service.ICustomerService;
import pe.com.projectbanco.impl.CustomerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomersController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Autowired
    PropertiesExternas prop;
    @Autowired
    ICustomerService iCustomerServ;
    @PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> createCustomer( @RequestBody Customer customer) {
        logger.info("{} {}", "1", "Inicio metodo del controller");
        logger.info("valor propertie: " + prop.valor);
        Customer p = iCustomerServ.create(customer);
        return new ResponseEntity<Customer>(p, HttpStatus.CREATED);
    }
    @GetMapping(value = "/findAll", consumes = "application/json", produces = "application/json")
    public ResponseEntity<List<Customer>> findAllCustomers() {
        logger.info("{} {}", "Inicio metodo del controller");
        logger.info("valor propertie: " + prop.valor);
        List<Customer> lista = iCustomerServ.findAll();
        return new ResponseEntity<List<Customer>>(lista, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Customer> changeCustomer(@RequestBody Customer customer){
        Customer p = iCustomerServ.update(customer);
        return new ResponseEntity<Customer>(p, HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Integer id) {
        Customer p = iCustomerServ.listarPorId(id);
        iCustomerServ.delete(id);
        return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
    }

}
