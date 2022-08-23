package pe.com.projectbanco.ProyectoI.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "customer")

public class Customer {
    @Id
    private String id;
    private String email;
    private String phone;
    private String address;
    private Integer id_customer_type;


}
