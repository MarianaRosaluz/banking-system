package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.BankDTO;
import br.rosaluz.banking.system.dto.LoginDTO;
import br.rosaluz.banking.system.dto.TokenDto;
import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.service.BankService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/bank", produces="application/json")
@Api(value="API REST Banking System")
public class BankController {


    @Autowired
    private BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }


    @PostMapping("/create")
    public ResponseEntity<TokenDto> create(@RequestBody @Valid BankDTO bankDTO, UriComponentsBuilder uriBuider)
    {
          Bank bank = bankDTO.convertBankDtoToBank();
          bankService.save(bank);

        URI uri = uriBuider.path("/bank/{id}").buildAndExpand(bank.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
