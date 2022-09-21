/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.controller;

import com.fstg.type_b.converter.impl.UserGetDtoConverter;
import com.fstg.type_b.converter.impl.UserPostConverter;
import com.fstg.type_b.dto.UserGetDto;
import com.fstg.type_b.dto.UserPostDto;
import com.fstg.type_b.service.UserService;
import io.swagger.annotations.Api;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@CrossOrigin(origins={"http://localhost:3000/","http://localhost:5000/"})
 @Api
@RestController
@RequiredArgsConstructor
@RequestMapping("api/user/")
public class UserController {
    final UserService utilisateurService;
final UserPostConverter utilisateurPostConverter;
final UserGetDtoConverter utilisateurGetDtoConverter;

@PostMapping("/")
public ResponseEntity<?> save( @RequestBody UserPostDto utilisateurPostDto) throws Exception {
if(utilisateurPostDto == null) 
return ResponseEntity.badRequest().body("L'utilisateur fourni n'est pas valid");
 return ResponseEntity.status(HttpStatus.CREATED).body(utilisateurGetDtoConverter.convertToDTO(utilisateurService.save(utilisateurPostDto)));
}

@PutMapping("/")
public ResponseEntity<?> update( @RequestBody UserPostDto utilisateurPostDto)throws Exception{
if(utilisateurPostDto == null) 
return ResponseEntity.badRequest().body("L'utilisateur fourni n'est pas valid");
return ResponseEntity.ok().body(utilisateurGetDtoConverter.convertToDTO(utilisateurService.update(utilisateurPostDto)));
}


@DeleteMapping("/id/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) throws Exception{
if(id == null ) return ResponseEntity.badRequest().body("L'identifiant fourni n'est pas valide");

return ResponseEntity.ok().body("L'utilisateur [ " + utilisateurService.delete(id) +" est supprimé avec success");
}

@GetMapping("/")
public ResponseEntity<List<UserGetDto>> findAll(){
return ResponseEntity.ok().body(utilisateurService.findAll());
}


}
