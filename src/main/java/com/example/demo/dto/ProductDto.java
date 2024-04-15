package com.example.demo.dto;



//import bzu.order_management.Entity.Product_orderPK;
import com.example.demo.entity.Product_orderPK;
import com.example.demo.entity.Warehouse;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class ProductDto {
    private Integer id;

    private String slug;

    private String name;

    private String reference;

    private Long price;

    private Long vat;

    private Boolean stackable;

    private List<Warehouse> warehouse;

    private List<Product_orderPK> product_order;
}
