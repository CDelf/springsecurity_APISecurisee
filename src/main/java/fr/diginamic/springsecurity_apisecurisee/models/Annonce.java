package fr.diginamic.springsecurity_apisecurisee.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titre;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_app_id")
    private UserApp userApp;

    public Annonce(String titre, String description, UserApp userApp) {
        this.titre = titre;
        this.description = description;
        this.userApp = userApp;
    }
}
