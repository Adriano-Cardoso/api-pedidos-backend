package com.api.order.domain.enums;

import com.api.order.validations.Message;
import lombok.Getter;

@Getter
public enum PaymentState {

    PENDING(1, "Pending"),
    SETTLED(2, "Settled"),
    CANCELED(3, "Canceled");

    private int code;
    private String description;

    private PaymentState(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static PaymentState toEnum(Integer code){
        if (code == null){
            return null;
        }
        for (PaymentState paymentState : PaymentState.values()) {
            if (code.equals(paymentState.getCode())) {
                return paymentState;
            }
        }
        throw Message.ID_INVALLID.asBusinessException();
    }
}
