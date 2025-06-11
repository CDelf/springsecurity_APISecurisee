package fr.diginamic.springsecurity_apisecurisee.services;

import fr.diginamic.springsecurity_apisecurisee.models.Annonce;
import fr.diginamic.springsecurity_apisecurisee.models.UserApp;
import fr.diginamic.springsecurity_apisecurisee.repositories.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnonceService {

    @Autowired
    AnnonceRepository annonceRepository;

    public List<Annonce> getAll() {
        return annonceRepository.findAll();
    }

    public void createAnnonce(String titre, String description, UserApp userApp) {
        annonceRepository.save(new Annonce(titre, description, userApp));
    }

    public void deleteById(Integer id) throws Exception {
        Optional<Annonce> annonceOptional = annonceRepository.findById(id);
        if (annonceOptional.isPresent()) {
            Annonce annonce = annonceOptional.get();
            annonce.setUserApp(null);
            annonceRepository.delete(annonce);
        } else {
            throw new Exception("Annonce non trouvée avec l'id : " + id);
        }
    }
}
