package com.example.aplicacion.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> { // Cambié Long por Integer
    User findByUsername(String username); // Método personalizado para buscar por username
}


