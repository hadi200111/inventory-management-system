package com.example.demo.Service;

import com.example.demo.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomer();

    CustomerDto getCustomerById(Integer id);

    CustomerDto updateCustomer(Integer id, CustomerDto customerDto);

    void deleteCustomer(Integer id);


}
