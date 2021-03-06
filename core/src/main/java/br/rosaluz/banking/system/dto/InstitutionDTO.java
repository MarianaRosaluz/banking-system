package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.model.Institution;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

public class InstitutionDTO {

    private String name;



    private Long bankId;

    public InstitutionDTO(String name, Long bankId) {
        this.name = name;
        this.bankId = bankId;
    }

    public Long getBankId() {
        return bankId;
    }

    public Institution convertInstitutionDtoToIntitution(Bank bank){

        return new Institution(name,bank.getId());

    }

}
