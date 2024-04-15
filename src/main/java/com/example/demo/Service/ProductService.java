package com.example.demo.Service;


import com.example.demo.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Integer id);

    ProductDto updateProduct(Integer id,ProductDto productDto);

    void deleteProduct(Integer id);

}
