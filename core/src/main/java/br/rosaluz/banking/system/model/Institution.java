package br.rosaluz.banking.system.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Institution {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    public Institution() {
    }

    @NotNull
    private String name;
    @NotNull
    private Long bankId;


    public Institution(String name, Long bankId) {
        this.name = name;
        this.bankId = bankId;
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

    public Long getBankId() {
        return bankId;
    }

    public void setBank(Long bankId) {
        this.bankId = bankId;
    }

}
