package com.fiap.food.api.order.service;

import com.fiap.food.api.AplicationConfigTest;
import com.fiap.food.api.assembler.CustomerMapper;
import com.fiap.food.api.assembler.OrderMapper;
import com.fiap.food.api.assembler.PaymentMapper;
import com.fiap.food.api.assembler.ProductMapper;
import com.fiap.food.api.customer.service.CustomerService;
import com.fiap.food.api.order.dto.OrderRequest;
import com.fiap.food.api.payment.dto.PaymentRequest;
import com.fiap.food.api.product.dto.ProductRequest;
import com.fiap.food.api.product.service.ProductService;
import com.fiap.food.client.service.PaymentClientService;
import com.fiap.food.core.exception.NotFoundException;
import com.fiap.food.core.model.*;
import com.fiap.food.core.repository.OrderRepository;
import com.fiap.food.enums.OrderStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@DisplayName("OrderServiceImplTest")
class OrderServiceImplTest extends AplicationConfigTest {

    @MockBean
    private OrderRepository orderRepository;

    @MockBean
    private OrderMapper orderEntityMapper;

    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductService productService;

    @MockBean
    private CustomerService customerService;

    @MockBean
    private CustomerMapper customerMapper;

    @MockBean
    private PaymentMapper paymentEntityMapper;

    @MockBean
    private PaymentClientService paymentClientService;

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("mustSaveOrder")
    public void mustSaveOrder() throws NotFoundException {
        // Cria uma entidade de cliente e de produto com valores predefinidos
        CustomerEntity customerEntity = getCustomerEntity(); // Assegure que essa entidade esteja corretamente populada
        ProductEntity productEntity = getProductEntity(); // Isso deve retornar um ProductEntity com um preço definido, exemplo: productEntity.setPrice(new BigDecimal("10.00"));

        // Mockando serviços e mapeadores
        Mockito.when(customerService.findByCpf(ArgumentMatchers.any())).thenReturn(customerEntity);
        Mockito.when(productService.findByProductName(any())).thenReturn(productEntity);

        // Mock para o mapper que converte de ProductEntity para ProductRequest
        ProductRequest productRequest = new ProductRequest();
        productRequest.setPrice(productEntity.getPrice()); // Assegura que a conversão mantenha o preço
        Mockito.when(productMapper.toRequest(any(ProductEntity.class))).thenReturn(productRequest);

        // Mock para o serviço de pagamento
        Mockito.when(paymentClientService.processarPagamento(any())).thenReturn("aprovado");

        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(1L);
        paymentEntity.setAmount(new BigDecimal(2));

        Mockito.when(paymentEntityMapper.toEntity(any(PaymentRequest.class))).thenReturn(paymentEntity);
        Mockito.when(orderEntityMapper.toEntity(any(OrderRequest.class))).thenReturn(getOrderEntity());

        // Executa o método insert para testar
        orderService.insert("88888888888", List.of("teste"));

        // Verifica se o método save do repositório foi chamado exatamente uma vez
        Mockito.verify(orderRepository, Mockito.times(1)).save(any(OrderEntity.class));
    }

    @Test
    @DisplayName("mustFindAllOrders")
    public void mustFindByIdCustomer() {
        Mockito.when(orderRepository.findOrdersOrderedByStatusAndDateTimeOrder()).thenReturn(getListOrderEntity());
        orderService.findAll();
        Mockito.verify(orderRepository, Mockito.times(1)).findOrdersOrderedByStatusAndDateTimeOrder();
    }

    @Test
    @DisplayName("mustfindByConfirmationCodeOrders")
    public void mustfindByConfirmationCodeOrders() throws NotFoundException {
        Mockito.when(orderRepository.findByConfirmationCode(any())).thenReturn(Optional.of(getOrderEntity()));
        orderService.findByConfirmationCode("");
        Mockito.verify(orderRepository, Mockito.times(1)).findByConfirmationCode(any());
    }

    @Test
    @DisplayName("mustUpdateConfirmOrder")
    public void mustUpdateCustomer() throws NotFoundException {
        orderService.updateConfirmOrder(getOrderEntity());
        Mockito.verify(orderRepository, Mockito.times(1)).save(any(OrderEntity.class));
    }

    @Test
    @DisplayName("mustPutStatusOrderByConfirmationCodeAndStatus")
    public void mustPutStatusOrderByConfirmationCodeAndStatus() throws NotFoundException {
        Mockito.when(orderRepository.findByConfirmationCode(any())).thenReturn(Optional.of(getOrderEntity()));
        orderService.putStatusOrderByConfirmationCodeAndStatus("teste", "RECEIVED");
        Mockito.verify(orderRepository, Mockito.times(1)).save(any(OrderEntity.class));
    }


    private List<OrderEntity> getListOrderEntity() {
        return List.of(getOrderEntity());
    }
    private OrderEntity getOrderEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1L);
        orderEntity.setCustomer(getCustomerEntity());
        orderEntity.setStatus(OrderStatus.IN_PREPARATION);
        orderEntity.setConfirmationCode("1234564654");

        return orderEntity;
    }

    private List<ProductRequest> getProductList() {
        List<ProductRequest> list = new ArrayList<>();
        list.add(getProductRequest());
        return list;
    }
    private OrderRequest getOrderRequest() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setDateTimeOrder(LocalDateTime.now());
        orderRequest.setStatus(OrderStatus.IN_PREPARATION);
        orderRequest.setCpfCustomer("88888888888");
        orderRequest.setProductsName(List.of("teste", "teste"));

        Mockito.when(orderRequest.getProducts()).thenReturn(getProductList());

        return orderRequest;
    }
    private CustomerEntity getCustomerEntity() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(1L);
        customerEntity.setName("Teste");
        customerEntity.setCpf("00000000000");
        customerEntity.setEmail("teste@mail");
        return customerEntity;
    }

    private ProductEntity getProductEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setCategory(getCategory());
        productEntity.setId(1L);
        productEntity.setPrice(50.0);
        productEntity.setInformation("teste");
        productEntity.setName("Teste");

        return productEntity;
    }
    private ProductRequest getProductRequest() {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setName("Teste");
        productRequest.setInformation("teste");
        productRequest.setPrice(1.0);
        productRequest.setNameCategory("teste");
        return productRequest;
    }

    private CategoryEntity getCategory() {

        var category = new CategoryEntity();
        category.setName("Teste");
        category.setId(1L);
        return category;
    }


}