package com.fiap.food.adapters.in.controller.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private String cpfCustomer;
    @NotEmpty
    @NotNull
    private List<String> productsName;

}
