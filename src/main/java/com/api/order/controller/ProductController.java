package com.api.order.controller;

import com.api.order.domain.request.CategoryRequest;
import com.api.order.domain.request.ProductRequest;
import com.api.order.domain.response.CategoryResponse;
import com.api.order.domain.response.ProductResponse;
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
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @ApiOperation(value = "Cria um novo produto")
    @PostMapping
    public ResponseEntity<ProductResponse> createNewCategory(@RequestBody ProductRequest productRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.productService.createNewProduct(productRequest));
    }
}
