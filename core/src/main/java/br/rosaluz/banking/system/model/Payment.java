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
    @NotNull
    @OneToMany
    private Institution institution;
    @NotNull
    private Long value;
    @NotNull
    private String nameDestination;
    @NotNull
    private String accountDestination;

    public Payment(Long accountPayment, Institution institution, Long value, String nameDestination, String accountDestination) {
        this.accountPayment = accountPayment;
        this.institution = institution;
        this.value = value;
        this.nameDestination = nameDestination;
        this.accountDestination = accountDestination;
    }
}
