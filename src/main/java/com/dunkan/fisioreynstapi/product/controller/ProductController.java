package com.dunkan.fisioreynstapi.product.controller;

import com.dunkan.fisioreynstapi.product.models.Product;
import com.dunkan.fisioreynstapi.product.payload.request.ProductData;
import com.dunkan.fisioreynstapi.product.payload.response.LocalizedProductData;
import com.dunkan.fisioreynstapi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Product create(@RequestBody ProductData productData) {
        return productService.create(productData);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<LocalizedProductData> get(@RequestParam Long id, @RequestParam(required = false) Locale language) {
        Optional<Product> product = productService.getProductById(id);
        if(product.isPresent()) {
            return ResponseEntity.ok(new LocalizedProductData(product.get(), language));
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<List<LocalizedProductData>> getAll(@RequestParam(required = false) Locale language) {
        List<Product> products = productService.getAllProducts(language);
        if(products != null && !products.isEmpty()) {
            List<LocalizedProductData> localizedProducts = new ArrayList<>(products.size());
            products.forEach(product -> localizedProducts.add(new LocalizedProductData(product, language)));
            return ResponseEntity.ok(localizedProducts);
        }
        return ResponseEntity.noContent().build();
    }

}
