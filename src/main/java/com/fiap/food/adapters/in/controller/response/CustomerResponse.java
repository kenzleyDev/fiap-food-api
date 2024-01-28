package com.fiap.food.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String cpf;
    private String email;
}
