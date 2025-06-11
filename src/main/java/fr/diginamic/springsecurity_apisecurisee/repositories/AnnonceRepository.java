package fr.diginamic.springsecurity_apisecurisee.repositories;

import fr.diginamic.springsecurity_apisecurisee.models.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Integer> {
}
