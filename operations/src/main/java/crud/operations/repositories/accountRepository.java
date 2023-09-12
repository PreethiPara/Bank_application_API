package crud.operations.repositories;

import crud.operations.model.account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import crud.operations.model.account;

public interface accountRepository extends CrudRepository<account,Integer>, JpaRepository <account,Integer>{
    @Query("select balance from account where accId=?1")
    int findBalanceByAccId(int accId);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update account set balance=balance+?2 where accId=?1")
    public void updateBalanceByaccId(int accId,int amount);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update account set balance=balance-?2 where accId=?1")
    public void withdrawByaccId(int accId,int amount);
}
