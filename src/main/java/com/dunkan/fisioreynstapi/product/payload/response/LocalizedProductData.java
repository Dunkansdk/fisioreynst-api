package com.dunkan.fisioreynstapi.product.payload.response;

import com.dunkan.fisioreynstapi.product.models.Product;
import lombok.Data;

import java.util.Locale;

@Data
public class LocalizedProductData {

    private Long id;
    private String image;
    private String name;
    private String description;

    public LocalizedProductData(Product product) {
        this.id = product.getId();
        this.image = product.getImage();
        this.name = product.getLocalizedName(null);
        this.description = product.getLocalizedDescription(null);
    }

    public LocalizedProductData(Product product, Locale locale) {
        this.id = product.getId();
        this.image = product.getImage();
        this.name = product.getLocalizedName(locale);
        this.description = product.getLocalizedDescription(locale);
    }

}
