package com.api.order.domain.response;

import com.api.order.domain.Adresses;
import com.api.order.domain.enums.TypeClient;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

public class ClientResponse {

    private Long clientId;
    private String name;
    private String email;
    private String cpfOuCnpj;
    private TypeClient type;
    private Long addressId;

    private List<AdressesResponse> addresses;

    private Set<String> phones;
}
