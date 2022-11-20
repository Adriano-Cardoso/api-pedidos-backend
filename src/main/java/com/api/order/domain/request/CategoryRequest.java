package com.api.order.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRequest {

    @NotEmpty(message = "O campo 'name' está inválido, no corpo da requisição")
    @Length(min = 5, max = 80, message = "O número de caracters deve está entra 5 e 80")
    @ApiModelProperty(position = 1, required = false, value = "name da categoria", name = "title", dataType = "String", example = "Cama mesa e banho")
    private String name;

}
