package com.api.order.service;

import com.api.order.domain.Category;
import com.api.order.domain.City;
import com.api.order.domain.Product;
import com.api.order.domain.State;
import com.api.order.domain.request.ProductRequest;
import com.api.order.domain.request.StateRequest;
import com.api.order.domain.response.ProductResponse;
import com.api.order.domain.response.StateResponse;
import com.api.order.repository.ProductRepository;
import com.api.order.repository.StateRepository;
import com.api.order.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service("StateService")
@AllArgsConstructor
@Validated
@Slf4j
public class StateService {

    private StateRepository stateRepository;

    public StateResponse createNewState(StateRequest stateRequest){
        this.stateRepository.findByName(stateRequest.getName()).ifPresent(productResponse ->{
            throw Message.NAME_STATE_EXISTS.asBusinessException();
        });

        State state = State.of(stateRequest);

        this.stateRepository.save(state);
        return state.toResponse();
    }

    public State findByIdState(Long productId){
        State state = this.stateRepository.findById(productId)
                .orElseThrow(Message.NOT_FOUND_ID_PRODUCT::asBusinessException);

        return state;
    }
}
