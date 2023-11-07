package com.myproject.bioshop.repository;


import com.myproject.bioshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

    void deleteUserByEmail(String email);

    Optional<User> findUserById(long id);
}
