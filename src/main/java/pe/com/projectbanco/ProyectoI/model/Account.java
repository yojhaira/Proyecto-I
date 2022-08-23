package pe.com.projectbanco.ProyectoI.model;

import org.springframework.data.annotation.Id;

import javax.validation.Valid;

public class Account {
    @Id
    private String id;
    private String codAccount;
    private String productType;
    private String authorization;
    private Double maintenanceFee;
    private int movementLimit;
    private int creditsAllowed;
    private boolean active = true;

    @Valid
    private Customer customer;

   /* @JsonIgnore
    public Client getClient() {
        return client;
    }*/
}
