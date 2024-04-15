package com.example.demo.Controller;



import com.example.demo.dto.OrderDto;
import com.example.demo.Service.OrderService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("order")
public class OrderController {
    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;


    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok().body(orderService.getAllOrders());
    }


    @GetMapping("{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable(name="id") Integer id){
        return ResponseEntity.ok().body(orderService.getOrderById(id));
    }


    @PostMapping("customer/{id}")
    public ResponseEntity<OrderDto> createOrder(@Valid @RequestBody OrderDto orderDto, @PathVariable(name="id") Integer id){
        if(orderDto.getId()!=null){
            log.error("Cannot have an ID {}" , orderDto);
        }
        return new ResponseEntity(orderService.createOrder(orderDto,id), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<OrderDto> updateOrder(@Valid @PathVariable(name="id") Integer id, @RequestBody OrderDto orderDto){
        return new ResponseEntity(orderService.updateOrder(id,orderDto),HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name="id") Integer id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
}

