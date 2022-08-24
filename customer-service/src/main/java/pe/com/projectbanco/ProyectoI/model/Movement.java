package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

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
    @Valid
    private Customer customer;

}

