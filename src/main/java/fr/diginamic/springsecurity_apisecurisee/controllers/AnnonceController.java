package fr.diginamic.springsecurity_apisecurisee.controllers;

import fr.diginamic.springsecurity_apisecurisee.models.Annonce;
import fr.diginamic.springsecurity_apisecurisee.models.UserApp;
import fr.diginamic.springsecurity_apisecurisee.services.AnnonceService;
import fr.diginamic.springsecurity_apisecurisee.services.JwtAuthentificationService;
import fr.diginamic.springsecurity_apisecurisee.services.UserAppService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class AnnonceController {

    @Autowired
    AnnonceService annonceService;
    @Autowired
    private UserAppService userAppService;
    @Autowired
    private JwtAuthentificationService jwtAuthentificationService;

    @GetMapping("/get-all")
    public List<Annonce> getAll() throws Exception {
        return annonceService.getAll();
    }

    @PostMapping("/create")
    public String createAnnonce(@RequestBody Annonce annonce, HttpServletRequest request) throws Exception {
        UserApp userApp = userAppService.getUserApp(
                jwtAuthentificationService.getEmailFromCookie(request)
        );
        annonceService.createAnnonce(
                annonce.getTitre(),
                annonce.getDescription(),
                userApp
        );
        return "Annonce créée";
    }

    @DeleteMapping("/delete-by-id/{id}")
    public String deleteAnnonce(@PathVariable Integer id) throws Exception {
        annonceService.deleteById(id);
        return "Annonce supprimée";
    }
}
