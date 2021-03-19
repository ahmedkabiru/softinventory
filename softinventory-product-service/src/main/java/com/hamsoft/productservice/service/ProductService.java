package com.hamsoft.productservice.service;

import com.hamsoft.productservice.domain.Product;
import com.hamsoft.productservice.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product saveProduct(Product product);

    ProductDTO findById(Long id);

    Page<ProductDTO> findAll(Pageable pageable);
}
