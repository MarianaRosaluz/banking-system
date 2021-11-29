package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.PaymentDTO;
import br.rosaluz.banking.system.model.Payment;
import br.rosaluz.banking.system.model.Transfer;

public interface PaymentService {
    public Payment save(Payment payment);
    public boolean makePayment(PaymentDTO paymentDTO);
}
