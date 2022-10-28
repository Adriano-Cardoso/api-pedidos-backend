package com.api.order.repository;

import com.api.order.domain.Product;
import com.api.order.domain.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
   @Query("SELECT NEW com.api.order.domain.response.ProductResponse(p.productId, p.name, p.price, p.categoryId) FROM Product p where p.name=:name")
   Optional<ProductResponse> findByName(String name);
}
