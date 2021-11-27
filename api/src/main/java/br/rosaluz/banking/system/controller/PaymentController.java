package br.rosaluz.banking.system.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/banking/system/payment", produces="application/json")
@Api(value="API REST Banking System")
public class PaymentController {

    //TODO FAZER PAGAMENTO DE UM BOLETO
}
