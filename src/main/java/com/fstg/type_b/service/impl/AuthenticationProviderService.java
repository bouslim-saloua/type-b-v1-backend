/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.service.impl;

import com.fstg.type_b.model.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@Service
public class AuthenticationProviderService implements AuthenticationProvider{
   @Autowired 
 private JpaUserDetailsService utilisateurDetailsService;






@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException{
BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
String username = authentication.getName();
String password = authentication.getCredentials().toString();

    CustomUserDetails utilisateur = utilisateurDetailsService.loadUserByUsername(username);
    
            
            return checkPassword(utilisateur, password, bCryptPasswordEncoder);
      
//throw new BadCredentialsException("Bad credentials");
}



@Override
public boolean supports(Class<?> aClass){
return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
}

private Authentication checkPassword(CustomUserDetails user, String rawPassword, PasswordEncoder encoder){
if(encoder.matches(rawPassword, user.getPassword())){
return new UsernamePasswordAuthenticationToken(
user.getUsername(),
user.getPassword(),
user.getAuthorities()
);
}else{
throw new BadCredentialsException("Bad credentials");
}
}

}
