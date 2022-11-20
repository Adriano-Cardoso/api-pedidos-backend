package com.api.order.repository;

import com.api.order.domain.Category;
import com.api.order.domain.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT NEW com.api.order.domain.response.CategoryResponse(c.categoryId, c.name) FROM Category c where c.name=:name")
    Optional<CategoryResponse> findByName(@Param("name") String name);

    @Query("SELECT NEW com.api.order.domain.response.CategoryResponse(c.categoryId, c.name) FROM Category c")
    Page<CategoryResponse> findAllCategory(Pageable pageable);
}
