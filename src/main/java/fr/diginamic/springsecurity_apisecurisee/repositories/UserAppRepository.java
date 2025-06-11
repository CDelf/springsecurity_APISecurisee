package fr.diginamic.springsecurity_apisecurisee.repositories;

import fr.diginamic.springsecurity_apisecurisee.models.UserApp;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAppRepository extends JpaRepository<UserApp, Integer> {

    Optional<UserApp> findByEmail (String email);
}
