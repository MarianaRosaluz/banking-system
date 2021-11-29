package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.Institution;
import br.rosaluz.banking.system.model.Payment;


public class PaymentDTO {

    private Long accountPayment;

    private Long institutionId;


    private Long value;

    public Long getAccountPayment() {
        return accountPayment;
    }

    public void setAccountPayment(Long accountPayment) {
        this.accountPayment = accountPayment;
    }

    public Long getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(Long institutionId) {
        this.institutionId = institutionId;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getNameDestination() {
        return nameDestination;
    }

    public void setNameDestination(String nameDestination) {
        this.nameDestination = nameDestination;
    }

    public String getAccountDestination() {
        return accountDestination;
    }

    public void setAccountDestination(String accountDestination) {
        this.accountDestination = accountDestination;
    }

    private String nameDestination;

    private String accountDestination;

    public PaymentDTO(Long accountPayment, Long institutionId, Long value, String nameDestination, String accountDestination) {
        this.accountPayment = accountPayment;
        this.institutionId = institutionId;
        this.value = value;
        this.nameDestination = nameDestination;
        this.accountDestination = accountDestination;
    }

    public Payment convertPaymentDtoToPayment(Institution institution) {

        return  new Payment(accountPayment, institution, value, nameDestination,accountDestination);
    }
}
