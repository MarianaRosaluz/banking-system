package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.model.Institution;
import br.rosaluz.banking.system.model.User;

import java.util.Optional;

public interface InstitutionService {

    public Institution save(Institution institution);
    public Optional<Institution> findById(Long id);

}
