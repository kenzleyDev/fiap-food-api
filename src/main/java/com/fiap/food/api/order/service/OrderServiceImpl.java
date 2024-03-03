package com.fiap.food.api.order.service;

import com.fiap.food.api.customer.dto.Customer;
import com.fiap.food.api.customer.service.CustomerService;
import com.fiap.food.api.order.dto.Order;
import com.fiap.food.api.order.mapper.OrderEntityMapper;
import com.fiap.food.api.payment.dto.Payment;
import com.fiap.food.api.payment.mapper.PaymentEntityMapper;
import com.fiap.food.api.product.dto.Product;
import com.fiap.food.api.product.mapper.ProductEntityMapper;
import com.fiap.food.api.product.service.ProductService;
import com.fiap.food.core.exception.NotFoundException;
import com.fiap.food.core.model.OrderEntity;
import com.fiap.food.core.model.PaymentEntity;
import com.fiap.food.core.repository.OrderRepository;
import com.fiap.food.enums.OrderStatus;
import com.fiap.food.enums.StatusPaymentEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    @Autowired
    private ProductEntityMapper productEntityMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PaymentEntityMapper paymentEntityMapper;

    @Override
    public List<Order> findAll() {
        List<OrderEntity> orders = orderRepository.findOrdersOrderedByStatusAndDateTimeOrder();
        return orders.stream().map(orderEntityMapper::toOrder).toList();
    }

    @Override
    public Optional<Order> findByConfirmationCode(String confirmationCode) {
        var orderEntity = orderRepository.findByConfirmationCode(confirmationCode);
        return orderEntity.map(entity -> orderEntityMapper.toOrder(entity));
    }

    @Override
    public void insert(String cpfCustomer, List<String> productsName) throws NotFoundException {
        Order order = new Order();
        order.setDateTimeOrder(LocalDateTime.now());
        order.setStatus(OrderStatus.RECEIVED);
        order.setConfirmationCode(UUID.randomUUID().toString());

        // Customer
        if (!Objects.isNull(cpfCustomer) && !cpfCustomer.isBlank()) {
            Optional<Customer> customer = customerService.findByCpf(cpfCustomer);
            customer.ifPresent(order::setCustomer);
        }

        // Product
        List<Product> products = new ArrayList<>();
        productsName.forEach(productName -> {
            Optional<Product> productOptional = productService.findByProductName(productName);
            productOptional.ifPresent(product -> {
                // Associando o produto à pedido
                product.setOrder(order);

                // Adicionando o produto à lista
                products.add(product);
            });
        });

        // Associando a lista de produtos à pedido
        order.setProducts(products);

        // cria pagamento
        var payment = new Payment();
        var totalSumOrderAmount = order.getProducts().stream()
                        .mapToDouble(Product::getPrice)
                                .sum();

        payment.setStatusPayment(StatusPaymentEnum.PENDING);
        payment.setAmount(new BigDecimal(totalSumOrderAmount));
        payment.setOrder(order);

        OrderEntity orderEntity = orderEntityMapper.toOrderEntity(order);
        PaymentEntity paymentEntity = paymentEntityMapper.toPaymentEntity(payment);

        paymentEntity.setOrder(orderEntity);
        orderEntity.setPayment(paymentEntity);

        orderRepository.save(orderEntity);
    }

    @Override
    public void updateConfirmOrder(Order order) {
        var orderEntity = orderEntityMapper.toOrderEntity(order);
        orderRepository.save(orderEntity);
    }

    @Override
    public void putStatusOrderByConfirmationCodeAndStatus(String confirmationCode, String status) throws NotFoundException {
        OrderEntity order = orderRepository.findByConfirmationCode(confirmationCode).orElseThrow(() -> new NotFoundException("Order not found"));
        var orderStatus = OrderStatus.fromString(status);
        order.setStatus(orderStatus);
        orderRepository.save(order);
    }
}
