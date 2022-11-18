package com.api.order.domain.response;

import com.api.order.domain.City;
import com.api.order.domain.Client;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class AdressesResponse {

    private Long addressId;
    private String logradouro;
    private String number;
    private String complemento;
    private String bairro;
    private String cep;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
