package com.example.demo.Service;



import com.example.demo.dto.OrderDto;
import com.example.demo.entity.Customer;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDto, Integer customerId);

    List<OrderDto> getAllOrders();

    List<OrderDto> getAllOrdersForCustomer(Integer id);

    OrderDto getOrderById(Integer id);

    OrderDto updateOrder(Integer id, OrderDto orderDto);

    void deleteOrder(Integer id);
}
