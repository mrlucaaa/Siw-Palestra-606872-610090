package it.uniroma3.siw.service;

import java.util.Collections;
import java.util.UUID;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.model.Credentials;
import it.uniroma3.siw.model.RuoloUtente;
import it.uniroma3.siw.model.Utente;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
    
    private final CredentialsService credentialsService;
    private final UtenteService utenteService;

    public CustomOAuth2UserService(CredentialsService credentialsService, UtenteService utenteService) {
        this.credentialsService = credentialsService;
        this.utenteService = utenteService;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        
        String email = oAuth2User.getAttribute("email");
        String firstName = oAuth2User.getAttribute("given_name");
        String lastName = oAuth2User.getAttribute("family_name");
        
        Credentials credentials = credentialsService.findCredentialsByUsername(email);
        
        if (credentials == null) {
            Utente newUser = new Utente();
            newUser.setNome(firstName != null ? firstName : "Utente");
            newUser.setCognome(lastName != null && !lastName.isBlank() ? lastName : "Sconosciuto");
            newUser.setEmail(email);
            // Il Codice Fiscale è obbligatorio (@NotBlank), quindi ne generiamo uno fittizio
            newUser.setCodiceFiscale("GGL-" + UUID.randomUUID().toString().substring(0, 10).toUpperCase());
            
            Credentials newCredentials = new Credentials();
            newCredentials.setUsername(email);
            // Generiamo una password casuale lunghissima (non verrà usata perché farà login con Google)
            newCredentials.setPassword(UUID.randomUUID().toString() + UUID.randomUUID().toString()); 
            newCredentials.setRuolo(RuoloUtente.CLIENTE);
            newCredentials.setUtente(newUser);
            
            credentialsService.saveCredentials(newCredentials);
        }
        
        // Spring Security richiede un oggetto OAuth2User configurato per capire i permessi
        return new DefaultOAuth2User(
            Collections.singleton(new SimpleGrantedAuthority("CLIENTE")),
            oAuth2User.getAttributes(),
            "email"
        );
    }
}
