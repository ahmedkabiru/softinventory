package com.hamsoft.productservice.service;

import com.hamsoft.productservice.client.CategoryClient;
import com.hamsoft.productservice.domain.Product;
import com.hamsoft.productservice.dto.ProductDTO;
import com.hamsoft.productservice.exception.ResourceNotFound;
import com.hamsoft.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements  ProductService{

    final ProductRepository productRepository;
    final ModelMapper modelMapper;
    final CategoryClient categoryClient;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ProductDTO findById(Long id) {
         return productRepository.findById(id).map(this::convertToDto).orElseThrow(()-> new ResourceNotFound("Not found id-" + id));
    }

    @Override
    public Page<ProductDTO> findAll(Pageable pageable) {
        return new PageImpl<>(productRepository.findAll(pageable).stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    private ProductDTO convertToDto(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);
        categoryClient.getCategory(product.getCategoryId()).ifPresent(productDTO::setCategory);
        return productDTO;
    }
}
