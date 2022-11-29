package com.api.order.domain.request;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientUpdateRequest {

    @NotEmpty(message = "O campo 'name' está inválido, no corpo da requisição")
    @Length(min = 5, max = 80, message = "O número de caracters deve está entra 5 e 80")
    private String name;

    @Email
    @NotEmpty(message = "O campo 'email' está inválido, no corpo da requisição")
    @Length(min = 5, max = 80, message = "O número de caracters deve está entra 5 e 80")
    private String email;
}
