package crud.operations.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="logger")
public class logger {
    @Id
    private int accId;
    private String transacType;
    private String transacStatus;
    private int initBal;
    private int finalBal;
    public logger(){}
    public logger(int accId, String transacType, String transacStatus, int initBal, int finalBal) {
        this.accId = accId;
        this.transacType = transacType;
        this.transacStatus = transacStatus;
        this.initBal = initBal;
        this.finalBal = finalBal;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public String getTransacType() {
        return transacType;
    }

    public void setTransacType(String transacType) {
        this.transacType = transacType;
    }

    public String getTransacStatus() {
        return transacStatus;
    }

    public void setTransacStatus(String transacStatus) {
        this.transacStatus = transacStatus;
    }

    public int getInitBal() {
        return initBal;
    }

    public void setInitBal(int initBal) {
        this.initBal = initBal;
    }

    public int getFinalBal() {
        return finalBal;
    }

    public void setFinalBal(int finalBal) {
        this.finalBal = finalBal;
    }
}
