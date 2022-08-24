package pe.com.projectbanco.ProyectoI.model;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movement")

public class Movement {
    @Id
    @BsonIgnore
    private ObjectId id;
    private String codMovement;
    private double availableBalance;
    private Integer limiteMovimiento;
    private double amount;
    private String dateOpen;
    @Valid
    private Customer customer;
    public Customer getCustomer() {
        return customer;
    }


}

