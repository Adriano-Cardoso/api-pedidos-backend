package com.api.order.controller;

import com.api.order.domain.request.CityRequest;
import com.api.order.domain.request.ProductRequest;
import com.api.order.domain.response.CityResponse;
import com.api.order.domain.response.ProductResponse;
import com.api.order.service.CityService;
import com.api.order.service.ProductService;
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
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    @ApiOperation(value = "Cria um novo cidade")
    @PostMapping
    public ResponseEntity<CityResponse> createNewCity(@RequestBody CityRequest cityRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cityService.createNewCity(cityRequest));
    }
}
