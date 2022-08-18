package pe.com.projectbanco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "customers")
public class Customer {
    @Id
    private String id;
    private String correo;
    private String direccion;
    private String nroDocumento;
    private String nombres;
    private String tipoCliente;
    private String tipoProducto;

}
