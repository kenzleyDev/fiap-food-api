package com.fiap.food.adapters.in.controller;

import com.fiap.food.adapters.in.controller.mapper.CategoryMapper;
import com.fiap.food.adapters.in.controller.request.CategoryRequest;
import com.fiap.food.adapters.in.controller.response.CategoryResponse;
import com.fiap.food.application.core.domain.Category;
import com.fiap.food.application.ports.in.category.DeleteCategoryByIdInputPort;
import com.fiap.food.application.ports.in.category.FindCategoryByIdInputPort;
import com.fiap.food.application.ports.in.category.InsertCategoryInputPort;
import com.fiap.food.application.ports.in.category.UpdateCategoryInputPort;
import com.fiap.food.errors.exception.NotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Category", description = "the Category Api")
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

    @Operation(
            summary = "Insert new Category",
            description = "save a new category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CategoryRequest categoryRequest) {
        Category category = categoryMapper.toCategory(categoryRequest);
        insertCategoryInputPort.insert(category);
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
        Category category = findCategoryByIdInputPort.find(id);
        var categoryResponse = categoryMapper.toCategoryResponse(category);
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
        updateCategoryInputPort.update(category);
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
        deleteCategoryByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
