package com.example.demo.dto;


import com.example.demo.entity.Customer;
import com.example.demo.entity.Product_orderPK;
import com.example.demo.entity.Order;
import com.example.demo.entity.Product_orderPK;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class OrderDto {

    private Integer id;

    private Date orderedAt;

    private List<Product_orderPK> product_order;
}
