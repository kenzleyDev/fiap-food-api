package com.fiap.food.api.payment.mapper;

import com.fiap.food.api.payment.dto.Payment;
import com.fiap.food.api.payment.dto.PaymentResponse;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentResponse toPaymentResponse(Payment payment);
}
