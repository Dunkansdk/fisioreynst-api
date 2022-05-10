package com.dunkan.fisioreynstapi.product.repository;

import com.dunkan.fisioreynstapi.authentication.models.Role;
import com.dunkan.fisioreynstapi.authentication.models.RoleEnum;
import com.dunkan.fisioreynstapi.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>  {
    Optional<Role> findById(RoleEnum name);
}
