package com.venkatesh.ProductService.service;

import com.venkatesh.ProductService.entity.Product;
import com.venkatesh.ProductService.exception.ProductServiceCustomException;
import com.venkatesh.ProductService.model.ProductRequest;
import com.venkatesh.ProductService.model.ProductResponse;
import com.venkatesh.ProductService.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public long addProduct(ProductRequest productRequest) {
        log.info("Adding Product..");
        Product product=
                Product.builder().productName(productRequest.getName())
                        .quantity(productRequest.getQuantity())
                        .price(productRequest.getPrice())
                        .build();
        productRepository.save(product);
        log.info("Product created");
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>Get the product for productid: {}",productId);
        Product product=
                productRepository.findById(productId).orElseThrow(()-> new ProductServiceCustomException("Product with given id not found","PRODUCT_NOT_FOUND"));

// =====================1st way of building ProductResponse object=================
//        ProductResponse productResponse=
//                new ProductResponse().builder().productId(product.getProductId())
//                        .productName(product.getProductName()).price(product.getPrice()).quantity(product.getQuantity()).build();

// =====================2nd way of building ProductResponse object=================
//        ProductResponse productResponse=
//                 ProductResponse.builder().productId(product.getProductId())
//                        .productName(product.getProductName()).price(product.getPrice()).quantity(product.getQuantity()).build();

// =====================3rd way of building ProductResponse object=================
        ProductResponse productResponse= new ProductResponse();
//        BeanUtils.copyProperties(product,productResponse);
        copyProperties(product,productResponse);
        return productResponse;

    }
}
