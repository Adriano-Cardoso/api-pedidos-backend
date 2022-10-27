package com.api.order.domain.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long productId;

    private String name;

    private Double price;

    private List<CategoryResponse> categoryResponses;
}
