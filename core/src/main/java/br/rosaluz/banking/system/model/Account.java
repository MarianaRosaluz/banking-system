package br.rosaluz.banking.system.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long agencyCode;
    @NotNull @Column(unique=true)
    private  Long accountNumber;
    @NotNull
    private  Long accountDigit;

    private  double balance;

    public Account(){}

    public Account(Long id,Long agencyCode, Long accountNumber, Long accountDigit,double balance) {
        this.id = id;
        this.agencyCode = agencyCode;
        this.accountNumber = accountNumber;
        this.accountDigit = accountDigit;
        this.balance = balance;
    }

    public Account(Long agencyCode, Long accountNumber, Long accountDigit,double balance) {
        this.agencyCode = agencyCode;
        this.accountNumber = accountNumber;
        this.accountDigit = accountDigit;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(Long agencyCode) {
        this.agencyCode = agencyCode;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getAccountDigit() {
        return accountDigit;
    }

    public void setAccountDigit(Long accountDigit) {
        this.accountDigit = accountDigit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
