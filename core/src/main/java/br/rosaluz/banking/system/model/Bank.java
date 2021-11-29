package br.rosaluz.banking.system.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Bank {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;
    @NotNull
    private String name;
    @NotNull
    private Long agency;

    public Bank(String name, Long agency) {
        this.name = name;
        this.agency = agency;
    }


}
