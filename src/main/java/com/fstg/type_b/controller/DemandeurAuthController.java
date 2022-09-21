/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.controller;

import com.fstg.type_b.model.CustomUserDetails;
import com.fstg.type_b.model.Demandeur;
import com.fstg.type_b.model.ERole;
import com.fstg.type_b.model.Role;
import com.fstg.type_b.payload.request.LoginRequest;
import com.fstg.type_b.payload.request.SignupRequest;
import com.fstg.type_b.payload.response.JwtResponse;
import com.fstg.type_b.payload.response.MessageResponse;
import com.fstg.type_b.repository.DemandeurRepository;
import com.fstg.type_b.repository.RoleRepository;
import com.fstg.type_b.repository.UserRepository;
import com.fstg.type_b.security.JwtUtils;
import io.swagger.annotations.Api;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@Api
@CrossOrigin(origins="http://localhost:3000/")
@RestController
@RequestMapping("/api/demandeur/auth")
public class DemandeurAuthController {
    @Autowired
    UserRepository userRepository;
     @Autowired
	       AuthenticationManager authenticationManager;
	@Autowired
	       DemandeurRepository demandeurRepository;
	@Autowired
	       RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	       JwtUtils jwtUtils;


//signIn

@PostMapping("/signIn")
	public ResponseEntity<?> authenticateDemandeur(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		  CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
//String accessToken, Long id, String email, String nom, String prenom,String telephone ,List<String> roles
	// public JwtResponse(String accessToken, Long id, String email, String nom, String prenom,String telephone ,List<String> roles) {	
return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(),
userDetails.getNom(), userDetails.getPrenom(), userDetails.getTelephone(),roles));
	}

@PostMapping("/signup")
	public ResponseEntity<?> registerDemandeur(@Valid @RequestBody SignupRequest signUpRequest) {
		//Error when email is already in use
		if (demandeurRepository.existsByEmail(signUpRequest.getEmail()) || userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

            //Error when phone is already in use!
if(demandeurRepository.existsByTelephone(signUpRequest.getTelephone()) || userRepository.existsByTelephone(signUpRequest.getTelephone())){
return ResponseEntity.badRequest().body(new MessageResponse("Erorr: N° Telephone est déjà utilisé!"));
}
		// Create new demandeur's account
		  Demandeur demandeur = new Demandeur( signUpRequest.getNom(), signUpRequest.getPrenom(),signUpRequest.getTelephone(), signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()), signUpRequest.getProfession());
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER);//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				
					Role userRole = roleRepository.findByName(ERole.ROLE_USER);//.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				
			});
		}
		demandeur.setRoles(roles);
		demandeurRepository.save(demandeur);
		return ResponseEntity.ok(new MessageResponse("Account registered successfully!"));
	}
}
