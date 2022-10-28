package com.api.order.domain;

import com.api.order.domain.request.ProductRequest;
import com.api.order.domain.response.ProductResponse;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String name;

    private Double price;

    @Column(name = "category_id", nullable = true, insertable = false, updatable = false)
    private Long categoryId;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public static Product of(ProductRequest productRequest) {
        return Product.builder()
                .name(productRequest.getName())
                .price(productRequest.getPrice())
                .categoryId(productRequest.getCategoryId()).build();
    }

    public ProductResponse toResponse() {
        return ProductResponse.builder().productId(this.getProductId())
                .name(this.getName())
                .price(this.price).categoryId(this.categoryId).build();
    }

    public void addCategory(Category category) {
        this.category = category;
        this.categoryId = category.getCategoryId();

    }
}
