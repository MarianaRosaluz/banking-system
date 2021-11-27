package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.LoginDTO;
import br.rosaluz.banking.system.dto.TokenDto;
import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Transfer;
import br.rosaluz.banking.system.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/banking/system/transfer", produces="application/json")
public class TransferController {

    @Autowired
    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }



    @PostMapping("/makeTransfer")
    public ResponseEntity<?> makeTransfer(@RequestBody @Valid TransferDTO transferDTO)
    {
            if(transferService.ValidateTransfer(transferDTO)){
                Transfer transfer = transferDTO.convertToTransfer();
                transferService.save(transfer);
                return ResponseEntity.ok().build();
            }else {
                return  ResponseEntity.badRequest().build();
            }
    }
}
