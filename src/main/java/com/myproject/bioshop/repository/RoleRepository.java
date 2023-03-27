package com.myproject.bioshop.repository;

import com.myproject.bioshop.model.entity.Role;
import com.myproject.bioshop.model.enums.RoleType;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    @Override
    List<Role> findAll();

    Role findByRole(String role);
}
