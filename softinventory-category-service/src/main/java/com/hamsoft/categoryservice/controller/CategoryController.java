package com.hamsoft.categoryservice.controller;

import com.hamsoft.categoryservice.domain.Category;
import com.hamsoft.categoryservice.dto.CategoryDTO;
import com.hamsoft.categoryservice.exception.ResourceNotFoundException;
import com.hamsoft.categoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/categories")
@Slf4j
@RequiredArgsConstructor
public class CategoryController {

    final CategoryService categoryService;

    @PostMapping
    public Category addCategory(@RequestBody CategoryDTO category) {
        return categoryService.save(category);
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isEmpty())
            throw new ResourceNotFoundException("Resource Not found with id-" + id);
        return category;
    }

    @GetMapping
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryService.findAll(pageable);
    }
}
