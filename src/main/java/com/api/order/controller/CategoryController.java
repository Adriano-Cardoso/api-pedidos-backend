package com.api.order.controller;

import com.api.order.domain.request.CategoryRequest;
import com.api.order.domain.response.CategoryResponse;
import com.api.order.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
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

    @ApiOperation(value = "Listar categorias")
    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> listAllCategory(
            @RequestParam(required = false, defaultValue = "0", name = "page") int page,
            @RequestParam(required = false, defaultValue = "24", name = "linesPerPage") int linesPerPage,
            @RequestParam(required = false, defaultValue = "name", name = "orderBy") String orderBy,
            @RequestParam(required = false, defaultValue = "ASC", name = "direction") String direction) {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.listAllCategory(page, linesPerPage, orderBy, direction));
    }

    @ApiOperation(value = "Atualização de categoria por id")
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable("categoryId") Long categoryId,
                                                         @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(this.categoryService.updateCategory(categoryId, categoryRequest));
    }

    @ApiOperation(value = "Exclusão de categoria por id")
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> deleteCategory(@PathVariable("categoryId") Long categoryId) {
        this.categoryService.deleteCategory(categoryId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
