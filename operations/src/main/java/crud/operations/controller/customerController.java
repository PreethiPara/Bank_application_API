package crud.operations.controller;
import crud.operations.model.customer;
import crud.operations.services.customerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import crud.operations.model.account;
@RestController
public class customerController {
    @Autowired
    private customerService customerservice;
    @Autowired
    private accountController accountcontroller;
    //CREATE NEW CUSTOMER, ACCOUNT NOT ACTIVE
    @PostMapping("/customer/createcustomer")
    public void createCustomer(@RequestBody customer c){
        customerservice.createCustomer(c);
        account a=new account(c.getAccId(),-1,"NOT ACTIVE");
        accountcontroller.createAccount(a);
    }
    //GET CUSTOMER INFO
    @GetMapping("/customer/{accId}")
    public customer getCustomerInfo(@PathVariable int accId){
        return customerservice.getCustomerInfo(accId);
    }
    @DeleteMapping("/customer/{accId}")
    public void deleteCustomer(@PathVariable int accId){
        customerservice.deleteCustomer(accId);
    }

}
