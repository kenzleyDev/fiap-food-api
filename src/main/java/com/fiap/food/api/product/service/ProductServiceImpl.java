package com.fiap.food.api.product.service;

import com.fiap.food.api.category.dto.Category;
import com.fiap.food.api.category.mapper.CategoryEntityMapper;
import com.fiap.food.api.category.service.CategoryService;
import com.fiap.food.api.product.mapper.ProductEntityMapper;
import com.fiap.food.api.product.dto.Product;
import com.fiap.food.core.exception.NotFoundException;
import com.fiap.food.core.model.ProductEntity;
import com.fiap.food.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityMapper productEntityMapper;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryEntityMapper categoryEntityMapper;
    @Override
    public void insert(Product product) throws NotFoundException {
        var productEntity = productEntityMapper.toProductEntity(product);
        Optional<Category> category = categoryService.find(product.getCategory().getName());
        productEntity.setCategory(categoryEntityMapper.toCategoryEntity(category.get()));
        productRepository.save(productEntity);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Product product) {
        var productEntity = productEntityMapper.toProductEntity(product);
        productRepository.save(productEntity);
    }

    @Override
    public List<Product> findByCategoryName(String categoryName) {
        List<ProductEntity> products = productRepository.findByCategoryName(categoryName);
        return products.stream().map(productEntityMapper::toProduct).toList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        var productEntity = productRepository.findById(id);
        return productEntity.map(entity -> productEntityMapper.toProduct(entity));
    }

    @Override
    public Optional<Product> findByProductName(String productName) {
        var productEntity = productRepository.findByName(productName);
        return productEntity.map(entity -> productEntityMapper.toProduct(entity));
    }
}
