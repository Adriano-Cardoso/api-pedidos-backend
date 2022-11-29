package com.api.order.controller;

import com.api.order.domain.request.ClientRequest;
import com.api.order.domain.request.ClientUpdateRequest;
import com.api.order.domain.response.ClientResponse;
import com.api.order.service.ClientService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class ClientController {


    private ClientService clientService;

    @ApiOperation(value = "Cria um novo cliente")
    @PostMapping
    public ResponseEntity<ClientResponse> createNewClient(@RequestBody ClientRequest clientRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.clientService.createCliente(clientRequest));
    }

    @ApiOperation(value = "Listar clientes")
    @GetMapping
    public ResponseEntity<Page<ClientResponse>> listAllCategory(
            @RequestParam(required = false, defaultValue = "0", name = "page") int page,
            @RequestParam(required = false, defaultValue = "24", name = "linesPerPage") int linesPerPage,
            @RequestParam(required = false, defaultValue = "name", name = "orderBy") String orderBy,
            @RequestParam(required = false, defaultValue = "ASC", name = "direction") String direction) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clientService.listAllClient(page, linesPerPage, orderBy, direction));
    }

    @ApiOperation(value = "Atualização de cliente por id")
    @PutMapping("/{categoryId}")
    public ResponseEntity<ClientResponse> updateCategory(@PathVariable("categoryId") Long clientId,
                                                         @RequestBody ClientUpdateRequest clientUpdateRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(this.clientService.updateCliente(clientId, clientUpdateRequest));
    }

    @ApiOperation(value = "Exclusão de cliente por id")
    @DeleteMapping("/{clientId}")
    public ResponseEntity<ClientResponse> deleteCategory(@PathVariable("clientId") Long clientId) {
        this.clientService.deleteClient(clientId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
