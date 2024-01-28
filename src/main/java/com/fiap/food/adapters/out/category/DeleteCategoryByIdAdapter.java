package com.fiap.food.adapters.out.category;

import com.fiap.food.adapters.out.repository.CategoryRepository;
import com.fiap.food.application.ports.out.category.DeleteCategoryByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryByIdAdapter implements DeleteCategoryByIdOutputPort {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
