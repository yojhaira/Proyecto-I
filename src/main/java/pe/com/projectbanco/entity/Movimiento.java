package pe.com.projectbanco.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "movimiento")
public class Movimiento {
    private String id;
    private String idCliente;
    private String idProducto;
    private double saldoDisponible;
    private double limiteMovimiento;
}
