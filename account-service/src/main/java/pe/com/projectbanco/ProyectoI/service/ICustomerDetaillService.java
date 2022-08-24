package pe.com.projectbanco.ProyectoI.service;

import pe.com.projectbanco.ProyectoI.model.Personal;
import pe.com.projectbanco.ProyectoI.model.dto.CustomerRequest;
import pe.com.projectbanco.ProyectoI.model.dto.CustomerResponse;


public interface ICustomerDetaillService extends  ICRUD<CustomerResponse,Integer> {
    CustomerResponse insertTypeCustomer(CustomerRequest dto);
}
