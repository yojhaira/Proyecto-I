package pe.com.projectbanco.ProyectoI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "account")
@Data

public class Account {
    private Integer idAccount;
    private Customer idCustomer;
    @JsonIgnore
    public Customer getCustomer() {
        return idCustomer;
    }
    private Product idProduct;
    @JsonIgnore
    public Product getProduct () { return idProduct;
    }
    private Date dateOpen;
    private double amount;
}
