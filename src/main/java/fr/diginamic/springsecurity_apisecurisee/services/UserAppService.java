package fr.diginamic.springsecurity_apisecurisee.services;

import fr.diginamic.springsecurity_apisecurisee.models.UserApp;
import fr.diginamic.springsecurity_apisecurisee.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAppService {
    @Autowired
    private UserAppRepository userAppRepository;
    @Autowired
    private JwtAuthentificationService jwtAuthentificationService;
    @Autowired
    private BCryptPasswordEncoder bcrypt;

    public void createUserApp(UserApp userApp, String role) throws Exception {
        Optional<UserApp> userAppOptional = userAppRepository.findByEmail(userApp.getEmail());
        if(userAppOptional.isPresent()){
            throw new Exception();
        }

        userAppRepository.save(new UserApp(
                userApp.getEmail(),
                bcrypt.encode(userApp.getPassword()),
                userApp.getNomEntreprise(),
                role
        ));
    }

    public UserApp getUserApp(String email) {
        return userAppRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + email ));
    }

    public ResponseCookie logUserApp(UserApp userApp) throws Exception {
        Optional<UserApp> userAppOptional = userAppRepository.findByEmail(userApp.getEmail());
        if(userAppOptional.isPresent() && bcrypt.matches(userApp.getPassword(), userAppOptional.get().getPassword())
        ){
            return jwtAuthentificationService.generateToken(userApp.getEmail());
        }
        throw new Exception();
    }
}
