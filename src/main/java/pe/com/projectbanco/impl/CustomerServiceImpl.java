package pe.com.projectbanco.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.com.projectbanco.entity.Customer;
import pe.com.projectbanco.repo.ICustomerServiceRepo;
import pe.com.projectbanco.service.ICustomerService;

import java.util.List;
@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerServiceRepo repo;

    @Override
    public Customer create(Customer obj) {
        return repo.save(obj);
    }

    @Override
    public Customer update(Customer obj) {
        return null;
    }

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer listarPorId(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
