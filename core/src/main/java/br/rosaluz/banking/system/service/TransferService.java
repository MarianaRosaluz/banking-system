package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Transfer;

public interface TransferService {

    public Transfer save(Transfer transfer);
    public  boolean makeTransfer(TransferDTO transferDTO);
}
