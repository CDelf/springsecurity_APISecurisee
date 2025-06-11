package fr.diginamic.springsecurity_apisecurisee.services;

import fr.diginamic.springsecurity_apisecurisee.models.Candidature;
import fr.diginamic.springsecurity_apisecurisee.repositories.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatureService {

    @Autowired
    CandidatureRepository candidatureRepository;

    public List<Candidature> getAll() {
        return candidatureRepository.findAll();
    }
}
