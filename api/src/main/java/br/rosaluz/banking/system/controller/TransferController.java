package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.LoginDTO;
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
