package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "business")
@Data

public class Business {
    @Id
    private String id;
    private String ruc;
    private String companyName;
    private String legalRepresentative;
    private Integer nroLegalRepresentative;
    private String signatory; // firmante
    private boolean pyme;

    List<String> personalIds;


}
