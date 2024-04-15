package com.example.demo.dto;



import lombok.Data;

import java.util.Date;
@Data
public class WarehouseDto {
    private Integer id;

    private Integer quantity;

    private Date updatedAt;
}

