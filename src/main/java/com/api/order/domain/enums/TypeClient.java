package com.api.order.domain.enums;

import com.api.order.validations.Message;
import lombok.Getter;

@Getter
public enum TypeClient {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "PESSOA JURIDICA");

    private Integer code;
    private String description;

    TypeClient(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public static TypeClient toEnum(Integer code){
        if (code == null){
            return null;
        }
        for (TypeClient typeClient : TypeClient.values()) {
            if (code.equals(typeClient.getCode())) {
                return typeClient;
            }
        }
        throw Message.ID_INVALLID.asBusinessException();
    }
}
