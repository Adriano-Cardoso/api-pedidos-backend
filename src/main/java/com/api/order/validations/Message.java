package com.api.order.validations;

import com.api.order.exception.BusinessException;
import org.springframework.http.HttpStatus;
public enum Message {
    NOT_FOUND_ID_CATEGORY("O Id da categoria não foi encontrado", HttpStatus.NOT_FOUND),
    NAME_EXISTS("O nome da categoria já existe em nossa base de dados", HttpStatus.BAD_REQUEST ),
    NOT_FOUND_ID_PRODUCT("Id do produto não encontrado", HttpStatus.NOT_FOUND),
    NAME_PRODUCT_EXISTS("Nome do produto já existe em nossa base", HttpStatus.BAD_REQUEST),
    NAME_STATE_EXISTS("O Estado já existe em nossa basa", HttpStatus.BAD_REQUEST),
    NAME_CITY_EXISTS("O nome da cidade já existe em nossa base", HttpStatus.BAD_REQUEST),
    NOT_FOUND_ID_CITY("Id da cidade não existe", HttpStatus.NOT_FOUND);

    private String value;
    private String description;
    private HttpStatus statusCode;

    private Message(String value, HttpStatus statusCode) {
        this.value = value;
        this.statusCode = statusCode;
    }

    private Message(String value, String description, HttpStatus statusCode) {
        this.value = value;
        this.description = description;
        this.statusCode = statusCode;
    }

    private Message(String value) {
        this.value = value;
    }

    public String getMessage() {
        return this.value;
    }

    public HttpStatus getStatus() {
        return this.statusCode;
    }

    public String getDescription() {
        return description;
    }

    public BusinessException asBusinessException() {
        return BusinessException.builder().httpStatusCode(this.getStatus())
                .code(String.valueOf(this.getStatus().value())).message(this.getMessage())
                .description(this.getDescription()).build();
    }
}
