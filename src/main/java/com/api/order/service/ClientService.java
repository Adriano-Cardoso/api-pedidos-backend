package com.api.order.service;

import com.api.order.domain.Addresses;
import com.api.order.domain.Client;
import com.api.order.domain.request.ClientRequest;
import com.api.order.domain.request.ClientUpdateRequest;
import com.api.order.domain.response.ClientResponse;
import com.api.order.repository.ClientRepository;
import com.api.order.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service("ClientService")
@AllArgsConstructor
@Validated
@Slf4j
public class ClientService {

    private ClientRepository clientRepository;

    private AddressService addressService;

    @Validated
    public ClientResponse createCliente(@Valid ClientRequest clientRequest){

        Addresses addresses = this.addressService.findByIdAddresses(clientRequest.getAddressId());

        this.clientRepository.findByCpfOuCnpj(clientRequest.getCpfOuCnpj()).ifPresent(clientResponse -> {
            throw Message.CPF_OR_CNPJ_EXISTS.asBusinessException();
        });

        Client client = Client.of(clientRequest);

        client.addAddress(addresses);

        this.clientRepository.save(client);

        return client.toResponse();
    }

    @Validated
    @Transactional
    public ClientResponse updateCliente(Long clientId, @Valid ClientUpdateRequest clientUpdateRequest){

        Client client = this.clientRepository.findById(clientId)
                .orElseThrow(Message.NOT_FOUND_ID_CLIENT::asBusinessException);

        client.updateClient(clientUpdateRequest);

        return client.toResponse();
    }

    public Page<ClientResponse> listAllClient(int page, int linesPerPage, String orderBy, String direction){

        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        log.info("method=listAllClient linesPerPage{}", linesPerPage);
        return this.clientRepository.findAllClient(pageable);

    }

    public void deleteClient(Long clientId){

        Client client = this.clientRepository.findById(clientId)
                .orElseThrow(Message.NOT_FOUND_ID_CLIENT::asBusinessException);

        this.clientRepository.delete(client);

    }
}
