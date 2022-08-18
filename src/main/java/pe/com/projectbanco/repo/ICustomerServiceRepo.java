package pe.com.projectbanco.repo;

import org.springframework.stereotype.Repository;
import pe.com.projectbanco.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ICustomerServiceRepo extends JpaRepository<Customer,Integer> {
}
