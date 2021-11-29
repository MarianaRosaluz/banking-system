package br.rosaluz.banking.system.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Transaction {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String origin;
    @NotNull
    private  String type;
    @NotNull
    private  Double value;
    @NotNull
    private  Account account;

    public Transaction(String origin, String type, Double value, Account account) {
        this.origin = origin;
        this.type = type;
        this.value = value;
        this.account = account;
    }
}
