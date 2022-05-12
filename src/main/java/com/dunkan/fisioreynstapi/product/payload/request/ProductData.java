package com.dunkan.fisioreynstapi.product.payload.request;

import lombok.Data;

import java.util.List;

@Data
public class ProductData {

    private Long id;
    private String image;
    private List<Producti18nData> localizations;

}
