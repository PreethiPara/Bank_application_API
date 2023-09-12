package crud.operations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crud.operations.model.account;
import crud.operations.repositories.accountRepository;
@Service
public class accountService {
    @Autowired
    private accountRepository accountrepository;
    public void createAccount(account a){
        accountrepository.save(a);
    }
    public account getAccountInfo(int id){
        return accountrepository.findById(id).orElse(null);
    }
    public void deleteAccount(int id){
        accountrepository.deleteById(id);
    }
    public int getBalance(int id){
        return accountrepository.findBalanceByAccId(id);
    }
    public void depositAmount(int id,int amount){
        accountrepository.updateBalanceByaccId(id,amount);
    }
    public void withdrawAccount(int id,int amount){
        accountrepository.withdrawByaccId(id,amount);
    }
    public void transferAmount(int sId,int destId,int amount){
        accountrepository.withdrawByaccId(sId,amount);
        accountrepository.updateBalanceByaccId(destId,amount);
    }



}
