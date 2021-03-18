package com.hamsoft.categoryservice.service;

import com.hamsoft.categoryservice.domain.Category;
import com.hamsoft.categoryservice.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    public Category save(CategoryDTO category);

    public Optional<Category> findById(Long id);

    public Page<Category> findAll(Pageable pageable);

}
