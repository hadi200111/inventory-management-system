package com.example.demo.Controller;


import com.example.demo.dto.ProductDto;
import com.example.demo.Service.ProductService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("product")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;


    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok().body(productService.getAllProducts());
    }


    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable(name="id") Integer id){
        return ResponseEntity.ok().body(productService.getProductById(id));
    }


    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto){
        return new ResponseEntity(productService.createProduct(productDto), HttpStatus.CREATED);
    }


    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@Valid @RequestBody ProductDto productDto,@PathVariable(name="id") Integer id){
        return new ResponseEntity(productService.updateProduct(id,productDto),HttpStatus.OK);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable(name="id") Integer id){
        return new ResponseEntity("Deleted successfully",HttpStatus.OK);
    }

}
