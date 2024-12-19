package com.example.aplicacion.User;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarioa") // Nombre de la tabla en la base de datos
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuarioA") // Nombre de la columna en la base de datos
    private Integer id; // Cambié de Long a Integer para reflejar el tipo de dato en la base de datos

    @Column(name = "Username", length = 45, nullable = false) // Mapear la columna "Username"
    private String username;

    @Column(name = "Password", length = 45, nullable = false) // Mapear la columna "Password"
    private String password;

    @Column(name = "Rol", length = 45, nullable = false) // Mapear la columna "Rol"
    private String role;

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
