package com.dunkan.fisioreynstapi.product.repository;

import com.dunkan.fisioreynstapi.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {

    Optional<Product> findById(Long id);

    @Query("SELECT product FROM Product product " +
            "JOIN product.localizations as localization " +
            "ON localization.product = product " +
            "WHERE localization.locale = :locale")
    Optional<List<Product>> findAllByLocale(Locale locale);

}
