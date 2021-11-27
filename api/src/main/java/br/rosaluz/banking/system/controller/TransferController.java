package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.LoginDTO;
import br.rosaluz.banking.system.dto.TokenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/banking/system/transfer", produces="application/json")
public class TransferController {

    @PostMapping("/makeTransfer")
    public ResponseEntity<TokenDto> authenticator(@RequestBody @Valid TransferDTO TransferDTO)
    {

    }
}
