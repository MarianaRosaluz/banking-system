package br.rosaluz.banking.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/banking/system/payment", produces="application/json")
public class PaymentController {

    //TODO FAZER PAGAMENTO DE UM BOLETO
}
