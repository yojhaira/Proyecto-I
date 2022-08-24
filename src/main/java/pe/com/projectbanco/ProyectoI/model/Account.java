package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
@Data

public class Account {
    @Id
    @BsonIgnore
    private ObjectId id;
    private String codAccount;
    private Date dateOpen;
    private double amount;
    @Valid
    private Product product;
    public Product getProduct() {
        return product;
    }
    public Product setProduct () {
        return product;
    }
}
