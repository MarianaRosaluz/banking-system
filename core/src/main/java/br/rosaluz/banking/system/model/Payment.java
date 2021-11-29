package br.rosaluz.banking.system.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @NotNull
    private Long accountPayment;
    @ManyToOne
    private Institution institution;
    @NotNull
    private Double value;

    public Long getId() {
        return id;
    }

    public Long getAccountPayment() {
        return accountPayment;
    }

    public Institution getInstitution() {
        return institution;
    }

    public Double getValue() {
        return value;
    }

    public String getNameDestination() {
        return nameDestination;
    }

    public String getAccountDestination() {
        return accountDestination;
    }

    @NotNull
    private String nameDestination;
    @NotNull
    private String accountDestination;

    public Payment(Long accountPayment, Institution institution, Double value, String nameDestination, String accountDestination) {
        this.accountPayment = accountPayment;
        this.institution = institution;
        this.value = value;
        this.nameDestination = nameDestination;
        this.accountDestination = accountDestination;
    }
}
