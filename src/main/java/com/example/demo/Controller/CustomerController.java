package com.example.demo.Controller;



import com.example.demo.dto.CustomerDto;
import com.example.demo.Service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("customer")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerService.getAllCustomer());
    }


    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable(name="id") Integer id){
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }


    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid  @RequestBody CustomerDto customerDto){
        if (customerDto.getId()!=null){
            log.error("Cannot have an ID {}" , customerDto);
        }
        return new ResponseEntity(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @PathVariable(name="id") Integer id, @RequestBody CustomerDto customerDto){
        return new ResponseEntity(customerService.updateCustomer(id,customerDto),HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(name="id") Integer id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }

}