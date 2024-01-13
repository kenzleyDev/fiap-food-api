package com.fiap.food.adapters.in.controller.request;

import com.fiap.food.application.core.domain.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {

    private String cpfCustomer;
    @NotBlank
    private List<String> productsName;

}
