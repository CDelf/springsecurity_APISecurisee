package fr.diginamic.springsecurity_apisecurisee.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Candidature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lettreMotivation;

    @ManyToOne
    @JoinColumn(name="user_app_id")
    private UserApp userApp;

    @ManyToOne
    @JoinColumn(name="annonce_id")
    private Annonce annonce;

    public Candidature(String lettreMotivation, UserApp userApp, Annonce annonce) {
        this.lettreMotivation = lettreMotivation;
        this.userApp = userApp;
        this.annonce = annonce;
    }
}
