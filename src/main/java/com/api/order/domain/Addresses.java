package com.api.order.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_address")
public class Addresses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Long addressId;
    private String logradouro;
    private String number;
    private String complemento;
    private String bairro;
    private String cep;

    @Column(name = "client_id", nullable = true, insertable = false, updatable = false)
    private  Long clientId;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = true)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = true)
    private City city;
}
