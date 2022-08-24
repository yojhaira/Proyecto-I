package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")

public class Customer {

    @Id
    @BsonIgnore
    private ObjectId id;
    private String codCustomer;
    private String nroDocument;/*DNI o RUC*/
    private String email;
    private String phone;
    private String address;
    private String customerType; /*Personal oEmpresarial*/
    private boolean active_s_n;
}
