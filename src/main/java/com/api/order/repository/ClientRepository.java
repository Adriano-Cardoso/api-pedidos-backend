package com.api.order.repository;

import com.api.order.domain.Client;
import com.api.order.domain.response.ClientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT NEW com.api.order.domain.response.ClientResponse(c.clientId, c.name, c.email, c.cpfOuCnpj, c.typeClient, c.addressId) FROM Client c where c.cpfOuCnpj=:cpfOuCnpj")
    Optional<ClientResponse> findByCpfOuCnpj(String cpfOuCnpj);

    @Query("SELECT NEW com.api.order.domain.response.ClientResponse(c.clientId, c.name, c.email, c.cpfOuCnpj, c.typeClient, c.addressId) FROM Client c ")
    Page<ClientResponse> findAllClient(Pageable pageable);
}
