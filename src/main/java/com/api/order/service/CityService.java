package com.api.order.service;

import com.api.order.domain.City;
import com.api.order.domain.State;
import com.api.order.domain.request.CityRequest;
import com.api.order.domain.response.CityResponse;
import com.api.order.repository.CityRepository;
import com.api.order.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service("CityService")
@AllArgsConstructor
@Validated
@Slf4j
public class CityService {

    private CityRepository cityRepository;

    private StateService stateService;

    public CityResponse createNewCity(CityRequest cityRequest) {
        this.cityRepository.findByName(cityRequest.getName()).ifPresent(cityResponse -> {
            throw Message.NAME_CITY_EXISTS.asBusinessException();
        });


        State state = this.stateService.findByIdState(cityRequest.getStateId());

        City city = City.of(cityRequest);

        city.addState(state);

        this.cityRepository.save(city);
        return city.toResponse();
    }

    public City findByIdState(Long cityId) {
        City city = this.cityRepository.findById(cityId)
                .orElseThrow(Message.NOT_FOUND_ID_CITY::asBusinessException);

        return city;
    }
}
