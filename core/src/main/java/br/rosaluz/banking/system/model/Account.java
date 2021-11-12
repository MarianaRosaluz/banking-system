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

    public Account(Long agencyCode, Long accountNumber, Long accountDigit) {
        this.agencyCode = agencyCode;
        this.accountNumber = accountNumber;
        this.accountDigit = accountDigit;
    }

}
