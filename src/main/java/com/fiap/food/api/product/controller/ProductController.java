package com.fiap.food.api.product.controller;

import com.fiap.food.api.category.dto.Category;
import com.fiap.food.api.product.dto.Product;
import com.fiap.food.api.product.dto.ProductRequest;
import com.fiap.food.api.product.dto.ProductResponse;
import com.fiap.food.api.product.mapper.ProductMapper;
import com.fiap.food.api.product.service.ProductService;
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
import java.util.stream.Collectors;

@Tag(name = "Product", description = "the Product Api")

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Operation(
            summary = "Insert new Product",
            description = "save a new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "409", description = "conflict operation"),
    })
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody ProductRequest productRequest) {
        var product = productMapper.toProduct(productRequest);
        Category category = new Category();
        category.setName(productRequest.getName());
        product.setCategory(category);
        productService.insert(product);
        return ResponseEntity.ok().build();
    }


    @Operation(
            summary = "Search Product",
            description = "Search a product by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
   @GetMapping("/{id}")
   public ResponseEntity<ProductResponse> findById(@PathVariable Long id) throws NotFoundException {
       var product = productService.findById(id);
       var productResponse = productMapper.toProductResponse(product.get());
       return ResponseEntity.ok().body(productResponse);
    }

    @Operation(
            summary = "Search Product by Category name",
            description = "Search a product by category name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
   @GetMapping("/category/{categoryName}")
   public ResponseEntity<List<ProductResponse>> findByCategoryName(@PathVariable String categoryName) throws NotFoundException {
       List<Product> products = productService.findByCategoryName(categoryName);

       List<ProductResponse> productResponses = products.stream()
                    .map(productMapper::toProductResponse)
                    .collect(Collectors.toList());
       return ResponseEntity.ok(productResponses);
        }

    @Operation(
            summary = "Search Product",
            description = "Search a product by product name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
   @GetMapping("/product/{productName}")
   public ResponseEntity<ProductResponse> findByProductName(@PathVariable String productName) throws NotFoundException {
      var product = productService.findByProductName(productName);
      var productResponse = productMapper.toProductResponse(product.get());
      return ResponseEntity.ok().body(productResponse);
    }

    @Operation(
            summary = "Update Product",
            description = "Update a product through a product request and its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "409", description = "conflict operation")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final Long id, @Valid @RequestBody ProductRequest productRequest) throws NotFoundException {
        Product product = productMapper.toProduct(productRequest);
        product.setId(id);
        Category category = new Category();
        category.setName(productRequest.getName());
        product.setCategory(category);
        productService.update(product);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Delete Product",
            description = "Deletes a product using id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) throws NotFoundException {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
