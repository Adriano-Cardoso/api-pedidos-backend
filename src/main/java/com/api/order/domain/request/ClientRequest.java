package com.api.order.domain.request;

import com.api.order.domain.enums.TypeClient;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequest {

    @NotEmpty(message = "O campo 'name' está inválido, no corpo da requisição")
    @Length(min = 5, max = 80, message = "O número de caracters deve está entra 5 e 80")
    private String name;

    @Email
    @NotEmpty(message = "O campo 'email' está inválido, no corpo da requisição")
    @Length(min = 5, max = 80, message = "O número de caracters deve está entra 5 e 80")
    private String email;

    @CPF
//    @CNPJ
    @NotEmpty(message = "O campo 'cpfOuCnpj' está inválido, no corpo da requisição")
    private String cpfOuCnpj;

//    @NotEmpty( message = "O campo 'type' está inválido, no corpo da requisição")
    @NotNull( message = "O campo 'type' está inválido, no corpo da requisição")
    private TypeClient typeClient;

//    @NotEmpty(message = "O campo 'addressId' está inválido, no corpo da requisição")
    private Long addressId;

    private String phone;

}
