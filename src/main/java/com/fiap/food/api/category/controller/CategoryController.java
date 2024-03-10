package com.fiap.food.api.category.controller;

import com.fiap.food.api.category.dto.Category;
import com.fiap.food.api.category.dto.CategoryRequest;
import com.fiap.food.api.category.dto.CategoryResponse;
import com.fiap.food.api.category.mapper.CategoryMapper;
import com.fiap.food.api.category.service.CategoryService;
import com.fiap.food.core.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Category", description = "the Category Api")
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Operation(
            summary = "Insert new Category",
            description = "save a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);
        categoryService.insert(category);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Search Category",
            description = "Search a categoy by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable final Long id) throws NotFoundException {
        Optional<Category> category = categoryService.find(id);
        var categoryResponse = categoryMapper.toCategoryResponse(category.get());
        return ResponseEntity.ok().body(categoryResponse);
    }

    @Operation(
            summary = "Update Category",
            description = "Update a category through a category request and its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final Long id, @Valid @RequestBody CategoryRequest categoryRequest) throws NotFoundException {
        Category category = categoryMapper.toCategory(categoryRequest);
        category.setId(id);
        categoryService.update(category);
        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Delete Category",
            description = "Deletes a category using id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "Not Found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) throws NotFoundException {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
