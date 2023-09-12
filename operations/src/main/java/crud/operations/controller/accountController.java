package crud.operations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import crud.operations.services.accountService;
import crud.operations.services.customerService;
import crud.operations.services.loggerService;
import crud.operations.model.account;
import crud.operations.model.logger;
import crud.operations.controller.loggerController;
@RestController
public class accountController {
    @Autowired
    private accountService AccountService;
    @Autowired
    private loggerService loggerservice;
    @Autowired
    private loggerController loggercontroller;

    //CREATE ACCOUNT
    @PostMapping("/createaccount")
    @ResponseStatus(HttpStatus.CREATED)
    public void createAccount(@RequestBody account a){
        AccountService.createAccount(a);
    }

    //CHECKING GET Balance
    @GetMapping("/account/{accId}/balance")
    public int getBalance(@PathVariable int accId){
        return AccountService.getBalance(accId);
    }

    //DEPOSIT AMOUNT
    @PutMapping("/account/{accId}/deposit/{amount}")
    public void depositAmount(@PathVariable int accId, @PathVariable int amount){
        int initialBalance=getBalance(accId);
        AccountService.depositAmount(accId,amount);
        logger l=new logger(accId,"Deposit","Succesful",initialBalance,initialBalance+amount);
        loggercontroller.addLog(l);
    }
    //WITHDRAW AMOUNT
    @PutMapping("/account/{accId}/withdraw/{amount}")
    public void withdrawAmount(@PathVariable int accId, @PathVariable int amount){
        int initialBalance=getBalance(accId);
        AccountService.withdrawAccount(accId,amount);
        logger l=new logger(accId,"withdrawal","Succesful",initialBalance,initialBalance-amount);
        loggercontroller.addLog(l);
    }

    //TRANSFER-TO OTHER ACCOUNT
    @PutMapping("/account/{sId}/transfer/{destId}/{amount}")
    public void transferAmount(@PathVariable int sId, @PathVariable int destId, @PathVariable int amount){
        int initialBalanceOfSender=getBalance(sId);
        int initialBalanceOfReceiver=getBalance(destId);
        AccountService.transferAmount(sId,destId,amount);
        logger l1=new logger(sId,"Sent","Succesful",initialBalanceOfSender,initialBalanceOfSender-amount);
        loggercontroller.addLog(l1);
        logger l2=new logger(destId,"Received","Succesful",initialBalanceOfReceiver,initialBalanceOfReceiver+amount);
        loggercontroller.addLog(l2);
    }

    //DELETE ACCOUNT
    @DeleteMapping("/account/{accId}")
    public void deleteAccount(@PathVariable int accId){
        AccountService.deleteAccount(accId);
        loggercontroller.deleteLog(accId);
    }
    //GET ACCOUNT INFORMATION

    @GetMapping("/account/{accId}")
    public account getAccountInfo(@PathVariable int accId){
        return AccountService.getAccountInfo(accId);
    }

}
