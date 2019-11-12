package com.example.smartmeter.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "SMARTMETER_READ")
public class SmartmeterRead {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "GAS_ID")
    private String gasId;

    @Column(name = "ELEC_ID")
    private String elecId;

    @Column(name = "ELEC_SMART_READ")
    private String elecSmartRead;

    @Column(name = "GAS_SMART_READ")
    private String gasSmartRead;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getGasId() {
        return gasId;
    }

    public void setGasId(String gasId) {
        this.gasId = gasId;
    }

    public String getElecId() {
        return elecId;
    }

    public void setElecId(String elecId) {
        this.elecId = elecId;
    }

    public String getElecSmartRead() {
        return elecSmartRead;
    }

    public void setElecSmartRead(String elecSmartRead) {
        this.elecSmartRead = elecSmartRead;
    }

    public String getGasSmartRead() {
        return gasSmartRead;
    }

    public void setGasSmartRead(String gasSmartRead) {
        this.gasSmartRead = gasSmartRead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartmeterRead that = (SmartmeterRead) o;
        return accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    @Override
    public String toString() {
        return "SmartMeterRead{" +
                "accountNumber='" + accountNumber + '\'' +
                ", gasId='" + gasId + '\'' +
                ", elecId='" + elecId + '\'' +
                ", elecSmartRead='" + elecSmartRead + '\'' +
                ", gasSmartRead='" + gasSmartRead + '\'' +
                '}';
    }


}
