package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.Transfer;

public class TransferDTO {

    public Long accountOrigin;
    public Long accountDestination;
    public  double value;
    public String type;

    public TransferDTO(Long accountOrigin, Long accountDestination, double value, String type) {
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
        this.value = value;
        this.type = type;
    }

    public Transfer convertToTransfer(){
        return new Transfer(accountOrigin, accountDestination,value,type);
    }
}
