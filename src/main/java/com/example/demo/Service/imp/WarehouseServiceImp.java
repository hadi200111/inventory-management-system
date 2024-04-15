package com.example.demo.Service.imp;



import com.example.demo.dto.WarehouseDto;
import com.example.demo.entity.Product;
import com.example.demo.entity.Warehouse;
import com.example.demo.reposetory.ProductRepository;
import com.example.demo.reposetory.WarehouseRepository;
import com.example.demo.Service.WarehouseService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImp implements WarehouseService {

    private Product product;

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public WarehouseDto createWarehouse(WarehouseDto warehouseDto,Integer productId) {
        Warehouse warehouse = mapToEntity(warehouseDto);
        Product product = productRepository.findById(productId).orElseThrow();
        warehouse.setProductID(product);

        Warehouse warehouse1 = warehouseRepository.save(warehouse);
        return mapToDto(warehouse1);
    }

    @Override
    public List<WarehouseDto> getAllWarehouse() {
        List<Warehouse> warehouses = warehouseRepository.findAll();
        return warehouses.stream().map(warehouse -> mapToDto(warehouse)).collect(Collectors.toList());
    }

    @Override
    public WarehouseDto getWarehouseById(Integer id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));
        return mapToDto(warehouse);
    }

    @Override
    public WarehouseDto updateWarehouse(Integer id, WarehouseDto warehouseDto) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));
        warehouse.setQuantity(warehouseDto.getQuantity());
        warehouse.setUpdatedAt(warehouseDto.getUpdatedAt());

        Warehouse stock1 = warehouseRepository.save(warehouse);
        return mapToDto(stock1);
    }

    @Override
    public void deleteWarehouse(Integer id) {
        Warehouse warehouse = warehouseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Warehouse", "id", id));
        warehouseRepository.delete(warehouse);
    }

    private WarehouseDto mapToDto(Warehouse warehouse){
        WarehouseDto warehouseDto = new WarehouseDto();
        warehouseDto.setId(warehouse.getId());
        warehouseDto.setQuantity(warehouse.getQuantity());
        warehouseDto.setUpdatedAt(warehouse.getUpdatedAt());
        return warehouseDto;
    }

    private Warehouse mapToEntity(WarehouseDto warehouseDto){
        Warehouse warehouse = new Warehouse();
        warehouse.setQuantity(warehouseDto.getQuantity());
        warehouse.setUpdatedAt(warehouseDto.getUpdatedAt());

        return warehouse;
    }
}

