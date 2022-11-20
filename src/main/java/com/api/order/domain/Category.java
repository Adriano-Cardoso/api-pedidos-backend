package com.api.order.domain;

import com.api.order.domain.request.CategoryRequest;
import com.api.order.domain.response.CategoryResponse;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    private String name;

    @ManyToMany(mappedBy = "categoryId")
    private List<Product> products;

    public static Category of(CategoryRequest categoryRequest) {
        return Category.builder()
                .name(categoryRequest.getName()).build();
    }

    public CategoryResponse toResponse() {
        return CategoryResponse.builder().categoryId(this.categoryId).name(this.name).build();
    }


    public void update(CategoryRequest categoryRequest) {
        this.name = categoryRequest.getName();
    }
}
