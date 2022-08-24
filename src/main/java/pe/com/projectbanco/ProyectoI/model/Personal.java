package pe.com.projectbanco.ProyectoI.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "personal")
@Data

public class Personal {
    @Id
    @BsonIgnore
    private ObjectId id;
    private String idPersonal;
    private String name;
    private String lastName;
    private String dni;
    private Customer customer;

}
