package crud.operations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crud.operations.repositories.customerRepository;
import crud.operations.model.customer;
@Service
public class customerService {
    @Autowired
    customerRepository customerrepository;
    public void createCustomer(customer c){
        customerrepository.save(c);
    }
    public customer getCustomerInfo(int id){
        return customerrepository.findById(id).orElse(null);
    }
    public void deleteCustomer(int id){
        customerrepository.deleteById(id);
    }

}
