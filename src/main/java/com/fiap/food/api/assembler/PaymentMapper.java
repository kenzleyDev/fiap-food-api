package com.fiap.food.api.assembler;

import com.fiap.food.api.category.dto.CategoryRequest;
import com.fiap.food.api.category.dto.CategoryResponse;
import com.fiap.food.api.payment.dto.PaymentRequest;
import com.fiap.food.api.payment.dto.PaymentResponse;
import com.fiap.food.api.product.dto.ProductRequest;
import com.fiap.food.client.dto.PaymentRequestClientDTO;
import com.fiap.food.core.model.CategoryEntity;
import com.fiap.food.core.model.PaymentEntity;
import com.fiap.food.core.model.ProductEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    private ModelMapper modelMapper;
    PropertyMap<PaymentRequestClientDTO, PaymentEntity> skipModifiedFieldsMap = new PropertyMap<>() {
        protected void configure() {
            // TODO document why this method is empty
        }
    };
    public PaymentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        this.modelMapper.addMappings(skipModifiedFieldsMap);
    }

    public PaymentEntity toEntity(PaymentRequest request) {

        return modelMapper.map(request, PaymentEntity.class);
    }

    public PaymentResponse toOutput(PaymentEntity paymentEntity) {

        return modelMapper.map(paymentEntity, PaymentResponse.class);
    }
}
