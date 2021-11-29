package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.SingInName;
import br.rosaluz.banking.system.dto.UserResponseDto;
import br.rosaluz.banking.system.model.Transaction;
import br.rosaluz.banking.system.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/transaction", produces="application/json")
@Api(value="API REST Banking System")
public class TransactionController {

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    private TransactionService transactionService;

    @GetMapping("/extract")
    public ResponseEntity<?> getExtract(@RequestParam(required = true) String accountNumber)
    {
        List<Transaction> transactions = transactionService.findByAccount(Long.parseLong(accountNumber));
        return ResponseEntity.ok(transactions);

    }
}
