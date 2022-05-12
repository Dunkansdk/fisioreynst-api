package com.dunkan.fisioreynstapi.product.repository;

import com.dunkan.fisioreynstapi.product.models.i18n.Producti18n;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Producti18nRepository extends JpaRepository<Producti18n, UUID> {
}
