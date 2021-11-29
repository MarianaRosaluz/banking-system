package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.InstitutionDTO;
import br.rosaluz.banking.system.dto.TokenDto;
import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.model.Institution;
import br.rosaluz.banking.system.service.BankService;
import br.rosaluz.banking.system.service.InstitutionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/Institution", produces="application/json")
@Api(value="API REST Banking System")
public class InstitutionController {



    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private BankService bankService;

    public InstitutionController(InstitutionService institutionService, BankService bankService) {
        this.bankService = bankService;
        this.institutionService = institutionService;
    }

    @PostMapping("/create")
    public ResponseEntity<TokenDto> create(@RequestBody @Valid InstitutionDTO institutionDTO, UriComponentsBuilder uriBuider) throws Exception {
        try {
            Optional<Bank> bank = bankService.findById(institutionDTO.getBankId());
            if (bank.isPresent()) {
                Institution institution = institutionDTO.convertInstitutionDtoToIntitution(bank.get());
                institutionService.save(institution);

                URI uri = uriBuider.path("/bank/{id}").buildAndExpand(institution.getId()).toUri();
                return ResponseEntity.created(uri).build();
            } else throw new Exception("id do banco invalido");

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

        }
}

