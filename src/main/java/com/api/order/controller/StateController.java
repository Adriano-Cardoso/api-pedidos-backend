package com.api.order.controller;

import com.api.order.domain.request.CityRequest;
import com.api.order.domain.request.StateRequest;
import com.api.order.domain.response.CityResponse;
import com.api.order.domain.response.StateResponse;
import com.api.order.service.CityService;
import com.api.order.service.StateService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/state")
public class StateController {

    private StateService stateService;

    @ApiOperation(value = "Cria um novo Estado")
    @PostMapping
    public ResponseEntity<StateResponse> createNewCity(@RequestBody StateRequest stateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.stateService.createNewState(stateRequest));
    }
}
