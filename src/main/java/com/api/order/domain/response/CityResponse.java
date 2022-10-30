package com.api.order.domain.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {

    private Long cityId;
    private String name;
    private Long stateId;

}
