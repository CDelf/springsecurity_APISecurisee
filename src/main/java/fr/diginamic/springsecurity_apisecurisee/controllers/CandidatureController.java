package fr.diginamic.springsecurity_apisecurisee.controllers;

import fr.diginamic.springsecurity_apisecurisee.models.Candidature;
import fr.diginamic.springsecurity_apisecurisee.services.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/candidature")
public class CandidatureController {

    @Autowired
    CandidatureService candidatureService;

    @GetMapping("/get-all")
    public List<Candidature> getAll() throws Exception {
        return candidatureService.getAll();
    }
}
