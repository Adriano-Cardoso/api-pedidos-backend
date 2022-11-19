package com.api.order.domain;

import com.api.order.domain.enums.PaymentState;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.Date;

/**
 * Classe pagamento com boleto
 */

@Getter
@Setter
@Entity
public class PaymentSlip extends Payment {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dueDate;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date paymentDate;


    public PaymentSlip(Long paymentId, PaymentState paymentState, Order order, Date dueDate, Date paymentDate) {
        super(paymentId, paymentState, order);
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
    }
}
