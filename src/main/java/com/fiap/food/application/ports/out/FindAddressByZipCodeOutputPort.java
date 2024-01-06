package com.fiap.food.application.ports.out;

import com.fiap.food.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
