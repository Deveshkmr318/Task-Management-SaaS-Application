package com.example.multitasker.repository;

import com.example.multitasker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByTenantId(Long tenantId);

    Optional<User> findByEmail(String email);

}
