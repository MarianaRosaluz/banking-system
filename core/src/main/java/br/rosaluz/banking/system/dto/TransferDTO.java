package br.rosaluz.banking.system.dto;

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
}
