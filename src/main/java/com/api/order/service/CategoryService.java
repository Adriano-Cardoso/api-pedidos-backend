package com.api.order.service;

import com.api.order.domain.Category;
import com.api.order.domain.request.CategoryRequest;
import com.api.order.domain.response.CategoryResponse;
import com.api.order.repository.CategoryRepository;
import com.api.order.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service("CategoryService")
@AllArgsConstructor
@Validated
@Slf4j
public class CategoryService {

    private CategoryRepository categoryRepository;

    public  CategoryResponse createNewCategory(CategoryRequest categoryRequest){

        this.categoryRepository.findByName(categoryRequest.getName()).ifPresent(categoryResponse -> {
            throw Message.NAME_EXISTS.asBusinessException();
        });

        Category category = Category.of(categoryRequest);

        this.categoryRepository.save(category);
        log.info("method=createNewCategory categoryId={} name={}", category.getCategoryId(), category.getName());

        return category.toResponse();
    }

    public CategoryResponse findByIdCategory(Long categoryId){
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(Message.NOT_FOUND_ID_CATEGORY::asBusinessException);

        return category.toResponse();
    }
}
