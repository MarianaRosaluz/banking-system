package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.TransferDTO;

public interface TransferService {

    public boolean ValidateTransfer(TransferDTO transferDTO);
}
