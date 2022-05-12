package com.dunkan.fisioreynstapi.product.service.impl;

import com.dunkan.fisioreynstapi.product.models.Product;
import com.dunkan.fisioreynstapi.product.models.i18n.Producti18n;
import com.dunkan.fisioreynstapi.product.payload.request.ProductData;
import com.dunkan.fisioreynstapi.product.repository.ProductRepository;
import com.dunkan.fisioreynstapi.product.repository.Producti18nRepository;
import com.dunkan.fisioreynstapi.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Producti18nRepository producti18nRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(ProductData productData) {
        Product product = new Product();
        product.setId(productData.getId());
        if(productData.getImage() != null) {
            product.setImage(productData.getImage());
        }

        Product localizedProduct = productRepository.save(product);

        Map<Locale, Producti18n> localizations = new HashMap<>();
        productData.getLocalizations().stream().forEach(localization -> {
            Producti18n producti18n = new Producti18n();
            producti18n.setName(localization.getName());
            producti18n.setDescription(localization.getDescription());
            producti18n.setLocale(Locale.forLanguageTag(localization.getLocale()));
            producti18n.setProduct(product);
            localizations.put(Locale.forLanguageTag(localization.getLocale()), producti18nRepository.save(producti18n));
        });

        return localizedProduct;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAllProducts(Locale locale) {
        if(locale == null) {
            return productRepository.findAll();
        }
        Optional<List<Product>> products = productRepository.findAllByLocale(locale);
        if(products.isPresent() && !products.get().isEmpty()) {
            return products.get();
        }
        return null;
    }
}
