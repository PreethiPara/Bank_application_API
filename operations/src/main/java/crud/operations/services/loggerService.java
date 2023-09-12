package crud.operations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import crud.operations.model.logger;
import crud.operations.repositories.loggerRepository;
@Service
public class loggerService {
    @Autowired
    loggerRepository loggerrepository;
    public void addLog(logger l){
        loggerrepository.save(l);
    }
    public logger showLog(int id){
        return loggerrepository.findById(id).orElse(null);
    }
    public void deleteLog(int id){
        loggerrepository.deleteById(id);
    }
}
