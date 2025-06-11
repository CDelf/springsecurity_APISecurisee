package fr.diginamic.springsecurity_apisecurisee.repositories;

import fr.diginamic.springsecurity_apisecurisee.models.Candidature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatureRepository extends JpaRepository<Candidature, Integer> {
}
