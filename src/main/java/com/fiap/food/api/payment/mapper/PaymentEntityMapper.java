package com.fiap.food.api.payment.mapper;

import com.fiap.food.api.order.mapper.OrderEntityMapper;
import com.fiap.food.api.payment.dto.Payment;
import com.fiap.food.api.payment.dto.PaymentResponse;
import com.fiap.food.core.model.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {OrderEntityMapper.class})
public interface PaymentEntityMapper {

    @Mapping(source = "order", target = "order")
    PaymentEntity toPaymentEntity(Payment payment);

    @Mapping(source = "order", target = "order")
    Payment toPayment(PaymentEntity paymentEntity);
    @Mapping(source = "order", target = "order")
    PaymentResponse toPaymentResponse(PaymentEntity paymentEntity);
}