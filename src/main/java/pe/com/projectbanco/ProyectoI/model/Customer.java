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
    private Object id;
    private String idCustomer;
    private String email;
    private String phone;
    private String address;
    private String customerType;
    private boolean active_s_n;


}
