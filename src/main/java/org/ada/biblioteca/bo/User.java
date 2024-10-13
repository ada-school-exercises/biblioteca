package org.ada.biblioteca.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    @Column(name = "date_creation")
    private LocalDateTime dateCreation;
    @Column(name = "date_update")
    private LocalDateTime dateUpdate;
}
