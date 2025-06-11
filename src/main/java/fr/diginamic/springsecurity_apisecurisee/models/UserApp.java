package fr.diginamic.springsecurity_apisecurisee.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="user_app")
public class UserApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String nomEntreprise;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "userApp")
    List<Annonce> annonces = new ArrayList<>();

    @OneToMany(mappedBy = "userApp")
    List<Candidature> candidatures = new ArrayList<>();

    public UserApp(String email, String password, String nomEntreprise, String role) {
        this.email = email;
        this.password = password;
        this.nomEntreprise = nomEntreprise;
        this.role = role;
    }
}
