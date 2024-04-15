package com.example.demo.dto;


import com.example.demo.entity.Product_orderPK;
import lombok.Data;

@Data
public class Product_orderDto {

    private Product_orderPK product_orderPK;

    private Integer quantity;

    private Long price;

    private Long vat;
}