package com.api.order.domain;

import com.api.order.domain.request.StateRequest;
import com.api.order.domain.response.CityResponse;
import com.api.order.domain.response.StateResponse;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_state")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private Long stateId;

    private String name;


    public StateResponse toResponse(){
        return StateResponse.builder()
                .stateId(this.stateId)
                .name(this.name).build();
    }

    public static State of(StateRequest stateRequest){
        return State.builder()
                .name(stateRequest.getName()).build();
    }



}
