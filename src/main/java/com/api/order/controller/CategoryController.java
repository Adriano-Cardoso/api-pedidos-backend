package com.api.order.controller;

import com.api.order.domain.request.CategoryRequest;
import com.api.order.domain.response.CategoryResponse;
import com.api.order.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    @ApiOperation(value = "Cria uma nova categoria")
    @PostMapping
    public ResponseEntity<CategoryResponse> createNewCategory(@RequestBody CategoryRequest categoryRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.categoryService.createNewCategory(categoryRequest));
    }

    @ApiOperation(value = "Busca a categoria pelo id")
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.findByIdCategory(categoryId));
    }
}
