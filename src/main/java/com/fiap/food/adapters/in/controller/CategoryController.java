package com.fiap.food.adapters.in.controller;

import com.fiap.food.adapters.in.controller.mapper.CategoryMapper;
import com.fiap.food.adapters.in.controller.request.CategoryRequest;
import com.fiap.food.adapters.in.controller.response.CategoryResponse;
import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.DeleteCategoryByIdInputPort;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.in.category.InsertCategoryInputPort;
import com.fiap.food.application.ports.in.category.UpdateCategoryInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private InsertCategoryInputPort insertCategoryInputPort;

    @Autowired
    private FindCategoryByIdInputPort findCategoryByIdInputPort;

    @Autowired
    private UpdateCategoryInputPort updateCategoryInputPort;

    @Autowired
    private DeleteCategoryByIdInputPort deleteCategoryByIdInputPort;

    @Autowired
    private CategoryMapper categoryMapper;
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);
        insertCategoryInputPort.insert(category);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable final Long id) {
        Category category = findCategoryByIdInputPort.find(id);
        var categoryResponse = categoryMapper.toCategoryResponse(category);
        return ResponseEntity.ok().body(categoryResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final Long id, @Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);
        category.setId(id);
        updateCategoryInputPort.update(category);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        deleteCategoryByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
