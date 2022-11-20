package com.api.order.service;

import com.api.order.domain.Category;
import com.api.order.domain.request.CategoryRequest;
import com.api.order.domain.response.CategoryResponse;
import com.api.order.repository.CategoryRepository;
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

@Service("CategoryService")
@AllArgsConstructor
@Validated
@Slf4j
public class CategoryService {

    private CategoryRepository categoryRepository;


    @Validated
    public CategoryResponse createNewCategory(@Valid CategoryRequest categoryRequest) {

        this.categoryRepository.findByName(categoryRequest.getName()).ifPresent(categoryResponse -> {
            throw Message.NAME_EXISTS.asBusinessException();
        });

        Category category = Category.of(categoryRequest);

        this.categoryRepository.save(category);
        log.info("method=createNewCategory categoryId={} name={}", category.getCategoryId(), category.getName());

        return category.toResponse();
    }

    public Category findByIdCategory(Long categoryId) {
        log.info("method=findByIdCategory categoryId={}", categoryId);
        return this.categoryRepository.findById(categoryId)
                .orElseThrow(Message.NOT_FOUND_ID_CATEGORY::asBusinessException);

    }

    @Validated
    @Transactional
    public  CategoryResponse updateCategory(Long categoryId, @Valid CategoryRequest categoryRequest){
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(Message.NOT_FOUND_ID_CATEGORY::asBusinessException);

        category.update(categoryRequest);
        log.info("method=updateCategory categoryId={} name={} ", category.getCategoryId(),
                category.getName());
        return category.toResponse();
    }

    public Page<CategoryResponse> listAllCategory(int page, int linesPerPage, String orderBy, String direction) {

        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        log.info("method=findAllVideoFree linesPerPage{}", linesPerPage);
        return this.categoryRepository.findAllCategory(pageable);
    }

    public void deleteCategory(Long categoryId){
        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(Message.NOT_FOUND_ID_CATEGORY::asBusinessException);

        log.info("method=deleteCategory categoryId={}", categoryId);
        this.categoryRepository.delete(category);
    }
}
