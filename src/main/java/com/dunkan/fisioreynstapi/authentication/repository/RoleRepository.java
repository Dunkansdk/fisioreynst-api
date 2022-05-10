package com.dunkan.fisioreynstapi.authentication.repository;

import com.dunkan.fisioreynstapi.authentication.models.RoleEnum;
import com.dunkan.fisioreynstapi.authentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
