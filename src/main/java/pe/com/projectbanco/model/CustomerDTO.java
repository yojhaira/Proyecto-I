package pe.com.projectbanco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String id;
    private String nroDocumento;
    private String nombres;
    private String tipoCliente;
}
