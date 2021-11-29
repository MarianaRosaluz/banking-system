package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.model.Institution;
import br.rosaluz.banking.system.repository.InstitutionRepository;

import java.util.Optional;

public class InstitutionServiceImpl implements  InstitutionService{



    private InstitutionRepository institutionRepository;

    public InstitutionServiceImpl(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public Institution save(Institution institution){
        return institutionRepository.save(institution);
    }

    @Override
    public Optional<Institution> findById(Long id){
        return institutionRepository.findById(id);
    }
}
