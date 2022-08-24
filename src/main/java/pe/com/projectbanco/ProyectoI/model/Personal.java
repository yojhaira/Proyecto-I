package pe.com.projectbanco.ProyectoI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "personal")
@Data

public class Personal {
    @Id
    private String idPersonal;
    private String name;
    private String lastName;
    private String dni;
    @Valid
    private Customer customer;

    @JsonIgnore
    public Customer getCustomer() {
        return customer;
    }
}
