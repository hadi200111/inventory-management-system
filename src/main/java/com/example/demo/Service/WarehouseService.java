package com.example.demo.Service;



import com.example.demo.dto.WarehouseDto;

import java.util.List;

public interface WarehouseService {
    WarehouseDto createWarehouse(WarehouseDto warehouseDto, Integer productId);

    List<WarehouseDto> getAllWarehouse();

    WarehouseDto getWarehouseById(Integer id);

    WarehouseDto updateWarehouse(Integer id,WarehouseDto warehouseDto);

    void deleteWarehouse(Integer id);
}

