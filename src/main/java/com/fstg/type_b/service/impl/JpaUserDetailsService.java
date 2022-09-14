/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.service.impl;

import com.fstg.type_b.model.CustomUserDetails;
import com.fstg.type_b.model.User;
import com.fstg.type_b.repository.UserRepository;
import java.util.function.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@RequiredArgsConstructor
@Service
public class JpaUserDetailsService implements UserDetailsService{
    
final UserRepository utilisateurRepository;

@Override
public CustomUserDetails loadUserByUsername(String username){
    Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");

    User utilisateur = utilisateurRepository.findByEmail(username).orElseThrow(s);
return CustomUserDetails.build(utilisateur);
}
}
