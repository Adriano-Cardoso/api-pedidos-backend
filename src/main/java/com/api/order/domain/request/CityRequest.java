package com.api.order.domain.request;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityRequest {

    private String name;

    private Long stateId;
}
