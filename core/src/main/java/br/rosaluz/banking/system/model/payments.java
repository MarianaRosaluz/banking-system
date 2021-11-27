package br.rosaluz.banking.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class payments {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private String accountPayment;
    @NotNull
    private String bankDestination;
    @NotNull
    private Long value;
    @NotNull
    private String nameDestination;
    @NotNull
    private String accountDestination;

    public payments(String accountPayment, String bankDestination, Long value, String nameDestination, String accountDestination) {
        this.accountPayment = accountPayment;
        this.bankDestination = bankDestination;
        this.value = value;
        this.nameDestination = nameDestination;
        this.accountDestination = accountDestination;
    }
}
