package com.hamsoft.productservice.dto;

import com.hamsoft.productservice.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
}
