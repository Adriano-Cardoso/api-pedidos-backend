package com.api.order.domain;

import com.api.order.domain.enums.TypeClient;
import com.api.order.domain.request.ClientRequest;
import com.api.order.domain.request.ClientUpdateRequest;
import com.api.order.domain.response.ClientResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;
    private String name;

    private String email;
    private String cpfOuCnpj;
    private TypeClient typeClient;

    @Column(name = "address_id", nullable = true, insertable = false, updatable = false)
    private Long addressId;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders;

    @ManyToMany(cascade = { CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private List<Addresses> addresses;

    @ElementCollection
    @CollectionTable(name = "tb_phone")
    private Set<String> phones;

    public ClientResponse toResponse(){
        return ClientResponse.builder()
                .clientId(this.clientId)
                .name(this.name)
                .email(this.email)
                .cpfOuCnpj(this.cpfOuCnpj)
                .typeClient(this.typeClient)
                .addressId(this.addressId).build();

    }

    public Long addAddressIdResponse(){

        this.addresses = new ArrayList<>();

        return null;
    }

    public static Client of(ClientRequest clientRequest){
        return Client.builder()
                .name(clientRequest.getName())
                .email(clientRequest.getEmail())
                .cpfOuCnpj(clientRequest.getCpfOuCnpj())
                .typeClient(clientRequest.getTypeClient())
//                .addresses(new ArrayList<Addresses>())
                .phones(new HashSet<String>())
                .build();

    }


    public void addAddress(Addresses addresses){
        this.addresses = new ArrayList<>();
        this.clientId = addresses.getClientId();
    }


    public void updateClient(ClientUpdateRequest clientUpdateRequest) {
        this.name = clientUpdateRequest.getName();
        this.email = clientUpdateRequest.getEmail();
    }
}
