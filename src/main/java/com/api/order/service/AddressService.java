package com.api.order.service;

import com.api.order.domain.Addresses;
import com.api.order.domain.Category;
import com.api.order.repository.AddressRepository;
import com.api.order.validations.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service("AddressService")
@AllArgsConstructor
@Validated
@Slf4j
public class AddressService {

    private AddressRepository addressRepository;


    public Addresses findByIdAddresses(Long addressId) {
        log.info("method=findByIdCategory categoryId={}", addressId);
        return this.addressRepository.findById(addressId)
                .orElseThrow(Message.NOT_FOUND_ID_ADDRESS::asBusinessException);

    }
}
