package com.api.order.domain.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StateResponse {

    private Long stateId;

    private String name;

}
