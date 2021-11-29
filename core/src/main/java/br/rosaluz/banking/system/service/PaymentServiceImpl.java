package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.PaymentDTO;
import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Account;
import br.rosaluz.banking.system.model.Institution;
import br.rosaluz.banking.system.model.Payment;
import br.rosaluz.banking.system.model.Transaction;
import br.rosaluz.banking.system.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PaymentServiceImpl implements  PaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private InstitutionService institutionService;
    @Autowired
    private  AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    public PaymentServiceImpl(PaymentRepository paymentRepository,InstitutionService institutionService, AccountService accountService,TransactionService transactionService) {

        this.accountService = accountService;
        this.institutionService = institutionService;
        this.paymentRepository = paymentRepository;
        this.transactionService = transactionService;
    }

    @Override
    public Payment save(Payment payment){
        return paymentRepository.save(payment);
    }


    public boolean validatePayment(PaymentDTO paymentDTO){

        if(ValidateInstitution(paymentDTO.getInstitutionId()))
            return true;
        else
            return  false;
    }
    private boolean ValidateInstitution(Long id){

        Optional<Institution> institution = institutionService.findById(id);
        if(institution.isPresent())
            return true;
        else
            return false;
    }
    @Override
    public  boolean makePayment(PaymentDTO paymentDTO){
        if(validatePayment(paymentDTO)){
            Double OldBalance = accountService.getBalance(paymentDTO.getAccountPayment());
            Double NewBalance = OldBalance - paymentDTO.getValue();
           Optional <Account> accountOptional = accountService.findByaccountNumber(paymentDTO.getAccountPayment());
            Account account = accountOptional.get();
             account.setBalance(NewBalance);
            accountService.save(account);
            Payment payment = paymentDTO.convertPaymentDtoToPayment(institutionService.findById(paymentDTO.getInstitutionId()).get());
            save(payment);
            transactionService.save(new Transaction("transfer","Debit", payment.getValue(),payment.getAccountPayment()));
            return  true;
        }
        else
            return false;
    }
}
