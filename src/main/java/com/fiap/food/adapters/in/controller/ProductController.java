package com.fiap.food.adapters.in.controller;

import com.fiap.food.adapters.in.controller.mapper.ProductMapper;
import com.fiap.food.adapters.in.controller.request.ProductRequest;
import com.fiap.food.adapters.in.controller.response.ProductResponse;
import com.fiap.food.application.core.domain.Product;
import com.fiap.food.application.ports.in.product.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private InsertProductInputPort insertProductInputPort;

    @Autowired
    private FindProductByIdInputPort findProductByIdInputPort;

    @Autowired
    private FindProductByCategoryNameInputPort findProductByCategoryNameInputPort;

    @Autowired
    private UpdateProductInputPort updateProductInputPort;

    @Autowired
    private DeleteProductByIdInputPort deleteProductByIdInputPort;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        insertProductInputPort.insert(product, productRequest.getNameCategory());
        return ResponseEntity.ok().build();
    }

        @GetMapping("/{id}")
        public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
            var product = findProductByIdInputPort.find(id);
            var productResponse = productMapper.toProductResponse(product);

            return ResponseEntity.ok().body(productResponse);
        }

        @GetMapping("/category/{categoryName}")
        public ResponseEntity<List<ProductResponse>> findByCategoryName(@PathVariable String categoryName) {
            List<Product> products = findProductByCategoryNameInputPort.find(categoryName);

            List<ProductResponse> productResponses = products.stream()
                    .map(productMapper::toProductResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(productResponses);
        }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final Long id, @Valid @RequestBody ProductRequest productRequest){
        Product product = productMapper.toProduct(productRequest);
        product.setId(id);
        updateProductInputPort.update(product, productRequest.getNameCategory());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        deleteProductByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
