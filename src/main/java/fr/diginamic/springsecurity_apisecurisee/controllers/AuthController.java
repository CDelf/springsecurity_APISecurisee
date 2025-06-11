package fr.diginamic.springsecurity_apisecurisee.controllers;

import fr.diginamic.springsecurity_apisecurisee.models.UserApp;
import fr.diginamic.springsecurity_apisecurisee.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserAppService userAppService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserApp userApp) throws Exception {
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, userAppService.logUserApp(userApp).toString())
                .body("vous êtes login");
    }

    @PostMapping("/create-candidat")
    public String createCandidat(@RequestBody UserApp userApp) throws Exception {
        userAppService.createUserApp(userApp, "ROLE_CANDIDAT");
        return "candidat créé";
    }

    @PostMapping("/create-recruteur")
    public String createRecruteur(@RequestBody UserApp userApp) throws Exception {
        userAppService.createUserApp(userApp, "ROLE_RECRUTEUR");
        return "recruteur créé";
    }

    @PostMapping("/create-admin")
    public String createAdmin(@RequestBody UserApp userApp) throws Exception {
        userAppService.createUserApp(userApp, "ROLE_ADMIN");
        return "admin créé";
    }
}
