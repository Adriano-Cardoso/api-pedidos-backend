package com.api.order.domain;

import com.api.order.domain.enums.TypeClient;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String name;
    private String email;
    private String cpfOuCnpj;
    private TypeClient type;

    @Column(name = "addressId", nullable = true, insertable = false, updatable = false)
    private Long addressId;


    @OneToMany(mappedBy = "client")
    private List<Adresses> addresses;

    @ElementCollection
    @CollectionTable(name = "tb_phone")
    private Set<String> phones;
}
