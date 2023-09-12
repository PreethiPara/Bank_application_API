package crud.operations.controller;
import crud.operations.model.logger;
import crud.operations.services.loggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loggerController {
    @Autowired
    private loggerService loggerservice;
    public void addLog(logger l){
        loggerservice.addLog(l);
    }
    @GetMapping("/account/{accId}/logs")
    public logger showLog(@PathVariable int accId){
        return loggerservice.showLog(accId);
    }
    public void deleteLog(int accId){
        loggerservice.deleteLog(accId);
    }
}
