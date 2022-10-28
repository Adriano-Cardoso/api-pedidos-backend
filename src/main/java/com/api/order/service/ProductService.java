package com.api.order.service;

import com.api.order.domain.Category;
import com.api.order.domain.Product;
import com.api.order.domain.request.ProductRequest;
import com.api.order.domain.response.ProductResponse;
import com.api.order.repository.ProductRepository;
import com.api.order.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service("ProductService")
@AllArgsConstructor
@Validated
@Slf4j
public class ProductService {

    private ProductRepository productRepository;

    private CategoryService categoryService;

    public ProductResponse createNewProduct(ProductRequest productRequest){
        this.productRepository.findByName(productRequest.getName()).ifPresent(productResponse ->{
            throw Message.NAME_PRODUCT_EXISTS.asBusinessException();
        });

        Category category =  this.categoryService.findByIdCategory(productRequest.getCategoryId());

        Product product = Product.of(productRequest);

        product.addCategory(category);

        this.productRepository.save(product);
        return product.toResponse();
    }

    public Product findByIdProduct(Long productId){
        Product product = this.productRepository.findById(productId)
                .orElseThrow(Message.NOT_FOUND_ID_PRODUCT::asBusinessException);

        return product;
    }
}
