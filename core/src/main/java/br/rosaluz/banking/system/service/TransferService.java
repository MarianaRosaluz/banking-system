package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Transfer;

public interface TransferService {

    public boolean ValidateTransfer(TransferDTO transferDTO);
    public Transfer save(Transfer transfer);
}
