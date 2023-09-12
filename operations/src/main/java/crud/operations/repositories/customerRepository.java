package crud.operations.repositories;
import crud.operations.model.customer;
import org.springframework.data.repository.CrudRepository;

public interface customerRepository extends CrudRepository<customer,Integer> {

}
