package com.example.demo.Service.imp;


import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.reposetory.ProductRepository;
import com.example.demo.Service.ProductService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapToEntity(productDto);
        productRepository.save(product);

        ProductDto productDto1 = mapToDto(product);
        return productDto1;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> mapToDto(product)).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        return mapToDto(product);
    }

    @Override
    public ProductDto updateProduct(Integer id, ProductDto productDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setStackable(productDto.getStackable());
        product.setVat(productDto.getVat());
        product.setWarehouses(productDto.getWarehouse());

        Product product1 = productRepository.save(product);

        return mapToDto(product1);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
        productRepository.delete(product);
    }
    private ProductDto mapToDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setReference(product.getReference());
        productDto.setSlug(product.getSlug());
        productDto.setStackable(product.getStackable());
        productDto.setWarehouse(product.getWarehouses());
        productDto.setVat(product.getVat());
        return productDto;
    }

    private Product mapToEntity(ProductDto productDto){
        Product product=new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setStackable(productDto.getStackable());
        product.setVat(productDto.getVat());
        product.setWarehouses(productDto.getWarehouse());
        return product;
    }
}
