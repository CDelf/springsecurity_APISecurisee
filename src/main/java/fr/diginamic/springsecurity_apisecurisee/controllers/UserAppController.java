package fr.diginamic.springsecurity_apisecurisee.controllers;

import fr.diginamic.springsecurity_apisecurisee.models.UserApp;
import fr.diginamic.springsecurity_apisecurisee.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserAppController {

    @Autowired
    UserAppService userAppService;

    @GetMapping("/get-all")
    public List<UserApp> getAll() throws Exception {
        return userAppService.getAll();
    }


}
