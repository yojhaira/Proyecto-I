package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "business")
@Data

public class Business {
    @Id
    private String id;
    private String idBusiness;
    private String ruc;
    private String companyName;
    private String legalRepresentative;
    private Integer nroLegalRepresentative;
    @Valid
    private Customer customer;


}
