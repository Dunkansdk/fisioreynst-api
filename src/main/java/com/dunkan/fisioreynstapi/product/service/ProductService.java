package com.dunkan.fisioreynstapi.product.service;

import com.dunkan.fisioreynstapi.product.models.Product;
import com.dunkan.fisioreynstapi.product.payload.request.ProductData;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface ProductService {

    Product create(ProductData productData);
    Optional<Product> getProductById(Long id);

    List<Product> getAllProducts(Locale locale);

}
