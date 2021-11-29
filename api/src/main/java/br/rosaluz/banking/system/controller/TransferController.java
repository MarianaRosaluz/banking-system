package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.LoginDTO;
import br.rosaluz.banking.system.dto.PaymentDTO;
import br.rosaluz.banking.system.dto.TokenDto;
import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Transfer;
import br.rosaluz.banking.system.service.TransferService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/transfer", produces="application/json")
@Api(value="API REST Banking System")
public class TransferController {

    @Autowired
    private TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }



    @PostMapping("/maketransfer")
    public ResponseEntity<TokenDto> makeTransfer(@RequestBody @Valid TransferDTO transferDTO )throws Exception {
        try {
            Boolean completed = transferService.makeTransfer(transferDTO);
            if (completed) {

                return ResponseEntity.ok().build();
            } else throw new Exception("A transferencia não foi realizada");

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
