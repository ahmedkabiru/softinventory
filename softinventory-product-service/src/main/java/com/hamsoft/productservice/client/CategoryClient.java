package com.hamsoft.productservice.client;

import com.hamsoft.productservice.model.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "category-service")
public interface CategoryClient {

    @GetMapping("/categories/{id}")
    Optional<Category> getCategory(@PathVariable Long id);
}
