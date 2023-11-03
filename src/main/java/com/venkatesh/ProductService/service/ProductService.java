package com.venkatesh.ProductService.service;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
