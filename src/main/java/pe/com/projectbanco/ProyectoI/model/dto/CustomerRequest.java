package pe.com.projectbanco.ProyectoI.model.dto;

import lombok.Data;
import pe.com.projectbanco.ProyectoI.model.Business;
import pe.com.projectbanco.ProyectoI.model.Personal;


@Data
public class CustomerRequest {

    private Integer id;

    private String email;

    private String phone;

    private String address;

    private Personal personal;

    private Business business;


}
