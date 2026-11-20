package com.example.banque.utilisateur.out;

import com.example.banque.utilisateur.Utilisateur;
import com.example.banque.utilisateur.UtilisateurRepository;

import java.util.Optional;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/** Qui fait la requête en cours. Vide si personne n'est connecté. */
@Service 
public class UtilisateurCourant {

    private final UtilisateurRepository utilisateurs;

    public UtilisateurCourant(UtilisateurRepository utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    
    public Optional<Utilisateur> get() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
            return Optional.empty();
        }
        return utilisateurs.findByLogin(auth.getName());
    }
    
}
