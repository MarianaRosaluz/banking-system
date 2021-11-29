package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.Bank;

import javax.validation.constraints.NotNull;

public class BankDTO {

    private String name;


    private Long agency;

    public BankDTO(String name, Long agency) {
        this.name = name;
        this.agency = agency;
    }
    public Bank convertBankDtoToBank(){
        return new Bank(name,agency);
    }

}
