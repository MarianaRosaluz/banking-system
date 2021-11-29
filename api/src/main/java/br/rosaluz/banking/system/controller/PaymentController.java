package br.rosaluz.banking.system.controller;

import br.rosaluz.banking.system.dto.InstitutionDTO;
import br.rosaluz.banking.system.dto.PaymentDTO;
import br.rosaluz.banking.system.dto.TokenDto;
import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.model.Institution;
import br.rosaluz.banking.system.service.PaymentService;
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
@RequestMapping(value = "/api/banking/system/payment", produces="application/json")
@Api(value="API REST Banking System")
public class PaymentController {

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makepayment")
    public ResponseEntity<TokenDto> makePayment(@RequestBody @Valid PaymentDTO paymentDTO )throws Exception {
        try {
            Boolean completed = paymentService.makePayment(paymentDTO);
            if (completed) {

                return ResponseEntity.ok().build();
            } else throw new Exception("o pagamento não foi efetuado");

        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
