package com.api.order.domain.response;

import com.api.order.domain.enums.TypeClient;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponse {

    private Long clientId;
    private String name;
    private String email;
    private String cpfOuCnpj;
    private TypeClient typeClient;
    private Long addressId;
//    private String phone;
//    private Long cityId;

}
