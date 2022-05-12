package com.dunkan.fisioreynstapi.product.models;

import com.dunkan.fisioreynstapi.product.models.i18n.Producti18n;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Entity
@Table(name = "tbl_product")
@NoArgsConstructor
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @Column(length = 10, unique = true, nullable = false)
    private Long id;

    @Column(name = "image")
    private String image;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @MapKey(name = "locale")
    private Map<Locale, Producti18n> localizations = new HashMap<>();

    public String getLocalizedName(Locale language) {
        if(localizations.get(language) == null) {
            if(localizations.get(Locale.forLanguageTag("es")) == null) {
                return null;
            }
            else {
                return localizations.get(Locale.forLanguageTag("es")).getName();
            }
        }
        return localizations.get(language).getName();
    }

    public String getLocalizedDescription(Locale language) {
        if(localizations.get(language) == null) {
            if(localizations.get(Locale.forLanguageTag("es")) == null) {
                return null;
            }
            else {
                return localizations.get(Locale.forLanguageTag("es")).getDescription();
            }
        }
        return localizations.get(language).getDescription();
    }

}
