package pe.com.projectbanco.ProyectoI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movement")

public class Movement {
    @Id
    private String id;
    private Customer customer;
    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }
    private double availableBalance;
    private Integer limiteMovimiento;


}

