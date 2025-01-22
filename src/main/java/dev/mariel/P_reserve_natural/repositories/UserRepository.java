package dev.mariel.P_reserve_natural.repositories;

import dev.mariel.P_reserve_natural.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}