package com.example.demo.Controller;



import com.example.demo.dto.WarehouseDto;


import com.example.demo.Service.imp.WarehouseServiceImp;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("warehouse")
public class WarehouseController {

    private final Logger log = LoggerFactory.getLogger(WarehouseController.class);

    @Autowired
    private WarehouseServiceImp warehouseServiceImp;


    @GetMapping
    public ResponseEntity<List<WarehouseDto>> getAllWarehouse(){
        return ResponseEntity.ok().body(warehouseServiceImp.getAllWarehouse());
    }


    @GetMapping("{id}")
    public ResponseEntity<WarehouseDto> getWarehouseyId(@PathVariable(name="id") Integer id){

        return ResponseEntity.ok().body(warehouseServiceImp.getWarehouseById(id));
    }

    @PostMapping("product/{id}")
    public ResponseEntity<WarehouseDto> createWarehouse(@PathVariable(name="id") Integer productId,@Valid @RequestBody WarehouseDto warehouseDto){
        if(warehouseDto.getId()!=null){
            log.error("Cannot have an ID {}" , warehouseDto);
        }
        return new ResponseEntity(warehouseServiceImp.createWarehouse(warehouseDto,productId), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<WarehouseDto> updateWarehouse(@PathVariable(name="id") Integer id, WarehouseDto warehouseDto){
        return new ResponseEntity(warehouseServiceImp.updateWarehouse(id,warehouseDto),HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteWarehouse(@PathVariable(name="id")Integer id){
        warehouseServiceImp.deleteWarehouse(id);
        return new ResponseEntity("Deleted successfully",HttpStatus.OK);
    }
}

