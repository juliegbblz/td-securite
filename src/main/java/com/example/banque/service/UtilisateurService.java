package com.example.banque.service;

import java.util.ArrayList;
import java.util.Optional;

import com.example.banque.utilisateur.Utilisateur;
import com.example.banque.utilisateur.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UtilisateurService implements UserDetailsService {

    @Autowired
    UtilisateurRepository repository;

    @Override 
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        Optional<Utilisateur> res = repository.findByLogin(username);
        if(res.isPresent()){
            return new User(res.get().getLogin(),res.get().getMotDePasse(),new ArrayList<>());
        }else{
            throw new UsernameNotFoundException("L'utilisateur n'existe pas");
        }
    }
    
}
