package com.fiap.food.enums;

import com.fiap.food.core.exception.NotFoundException;

public enum StatusPaymentEnum {

    PENDING("PENDENTE"),
    APPROVED("APROVADO"),
    REFUSED("RECUSADO");

    private String statusPayment;

    StatusPaymentEnum(String statusPayment) {
        this.statusPayment = statusPayment;
    }

    public static StatusPaymentEnum fromString(String text) throws NotFoundException {
        for(StatusPaymentEnum statusPayment : StatusPaymentEnum.values()) {
            if(statusPayment.statusPayment.equals(text)) {
                return statusPayment;
            }
        }
        throw new NotFoundException("Status de order não encontrado: " + text);
    }
}
