package com.venkatesh.ProductService.controller;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;
import com.venkatesh.ProductService.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){
        long productId=productService.addProduct(productRequest);
        return new ResponseEntity<>(productId, HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") long productId){
        ProductResponse productResponse=
                productService.getProductById(productId);
        return new ResponseEntity<>(productResponse,HttpStatus.OK);
    }
}
