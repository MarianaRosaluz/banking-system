package br.rosaluz.banking.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Bank {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private  Long id;

    public Bank() {
    }

    @NotNull
    private String name;
    @NotNull
    private Long agency;

    public Bank(String name, Long agency) {
        this.name = name;
        this.agency = agency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAgency() {
        return agency;
    }

    public void setAgency(Long agency) {
        this.agency = agency;
    }


}
