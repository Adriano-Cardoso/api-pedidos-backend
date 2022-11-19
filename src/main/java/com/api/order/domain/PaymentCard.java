package com.api.order.domain;

import com.api.order.domain.enums.PaymentState;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * Classe pagamento com cartão
 */


@Getter
@Setter
@Entity
public class PaymentCard extends Payment {

    private Integer numberOfInstallments;

    public PaymentCard(Long paymentId, PaymentState paymentState, Order order, Integer numberOfInstallments) {
        super(paymentId, paymentState, order);
        this.numberOfInstallments = numberOfInstallments;
    }
}
