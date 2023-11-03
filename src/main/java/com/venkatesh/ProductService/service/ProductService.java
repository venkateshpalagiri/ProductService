package com.venkatesh.ProductService.service;

import com.venkatesh.ProductService.model.ProductRequest;

public interface ProductService {
    long addProduct(ProductRequest productRequest);
}
