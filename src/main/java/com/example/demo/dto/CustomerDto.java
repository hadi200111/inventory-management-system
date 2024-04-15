package com.example.demo.dto;

//import com.example.demo.entity.Order;
import com.example.demo.entity.Order;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
public class CustomerDto {
    private Integer id;

    private String firstName;

    private String LastName;

    private Date bornAt;

    private List<Order> order;

}
