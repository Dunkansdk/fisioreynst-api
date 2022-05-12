package com.dunkan.fisioreynstapi.product.models.i18n;

import com.dunkan.fisioreynstapi.product.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Locale;
import java.util.UUID;

@Entity
@Table(name = "tbl_product_i18n")
@Getter
@Setter
@NoArgsConstructor
public class Producti18n {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID textUUID;

    @ManyToOne
    @JoinColumn(name = "product")
    @JsonIgnore
    private Product product;

    @Column(name = "locale", length = 10)
    private Locale locale;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

}
