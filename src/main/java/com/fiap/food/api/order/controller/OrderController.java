package com.fiap.food.api.order.controller;

import com.fiap.food.api.order.dto.Order;
import com.fiap.food.api.order.dto.OrderRequest;
import com.fiap.food.api.order.dto.OrderResponse;
import com.fiap.food.api.order.mapper.OrderMapper;
import com.fiap.food.api.order.service.OrderService;
import com.fiap.food.core.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Order", description = "the Order Api")
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Operation(
            summary = "Insert new Order",
            description = "save a new order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "409", description = "conflict operation"),
    })
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody OrderRequest orderRequest) throws NotFoundException {
        orderService.insert(orderRequest.getCpfCustomer(), orderRequest.getProductsName());
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Find All Orders",
            description = "Search all registered orders ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
    })
    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        List<Order> orders = orderService.findAll();
        List<OrderResponse> response = orders.stream().map(orderMapper::toOrderResponse).toList();
        return ResponseEntity.ok().body(response);
    }

    @Operation(
            summary = "Search order by Confirmation Code",
            description = "Search a order by confirmation code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @GetMapping("/{confirmationCode}")
    public ResponseEntity<OrderResponse> findByConfirmationCode(@PathVariable final String confirmationCode) throws NotFoundException {
        var order = orderService.findByConfirmationCode(confirmationCode);
        var orderResponse = orderMapper.toOrderResponse(order.get());
        return ResponseEntity.ok().body(orderResponse);
    }

    @Operation(
            summary = "Update and confirm Order",
            description = "Update a Order and confirm status order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
    })
    @PutMapping("/confirm/{confirmationCode}")
    public ResponseEntity<Void> update(@PathVariable final String confirmationCode) throws NotFoundException {
        var order = orderService.findByConfirmationCode(confirmationCode);
        orderService.updateConfirmOrder(order.get());
        return ResponseEntity.noContent().build();

    }
}
