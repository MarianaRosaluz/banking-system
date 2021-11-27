package br.rosaluz.banking.system.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @NotNull
    private Long accountOrigin;
    @NotNull
    private Long accountDestination;
    @NotNull
    private Double value;
    @NotNull
    private String type;

    public Transfer(Long accountOrigin, Long accountDestination, Double value, String type) {
        this.accountOrigin = accountOrigin;
        this.accountDestination = accountDestination;
        this.value = value;
        this.type = type;
    }
}
