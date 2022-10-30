package com.api.order.domain;

import com.api.order.domain.request.CityRequest;
import com.api.order.domain.response.CityResponse;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;


@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_Id")
    private Long cityId;

    private String name;

    @Column(name = "state_id", nullable = true, insertable = false, updatable = false)
    private Long stateId;

    @ManyToOne
    @JoinColumn(name = "state_id", referencedColumnName = "state_id")
    private State state;

    public static City of(CityRequest cityRequest) {
        return City.builder()
                .name(cityRequest.getName())
                .stateId(cityRequest.getStateId()).build();
    }

    public CityResponse toResponse() {
        return CityResponse.builder().cityId(this.cityId).name(this.getName()).stateId(this.getStateId()).build();
    }

    public void addState(State state){
        this.state = state;
        this.stateId = state.getStateId();
    }


}
