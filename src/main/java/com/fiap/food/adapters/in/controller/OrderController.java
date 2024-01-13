package com.fiap.food.adapters.in.controller;

import com.fiap.food.adapters.in.controller.mapper.OrderMapper;
import com.fiap.food.adapters.in.controller.request.OrderRequest;
import com.fiap.food.adapters.in.controller.response.OrderResponse;
import com.fiap.food.application.core.domain.Order;
import com.fiap.food.application.ports.in.order.InsertOrderInputPort;
import com.fiap.food.application.ports.out.order.FindAllOrdersOutputPort;
import com.fiap.food.application.ports.out.product.FindProductByIdOutputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private InsertOrderInputPort insertOrderInputPort;

    @Autowired
    private FindAllOrdersOutputPort findAllOrdersOutputPort;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody OrderRequest orderRequest) {
        insertOrderInputPort.insert(orderRequest.getCpfCustomer(), orderRequest.getProductsName());
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<Order> orders = findAllOrdersOutputPort.findAll();
        List<OrderResponse> response = orders.stream().map(orderMapper::toOrderResponse).toList();
        return ResponseEntity.ok().body(response);
    }
}
