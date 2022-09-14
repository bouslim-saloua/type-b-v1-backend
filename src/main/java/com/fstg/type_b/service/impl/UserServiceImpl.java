/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.service.impl;

import com.fstg.type_b.converter.impl.UserGetDtoConverter;
import com.fstg.type_b.converter.impl.UserPostConverter;
import com.fstg.type_b.dto.UserGetDto;
import com.fstg.type_b.dto.UserPostDto;
import com.fstg.type_b.model.User;
import com.fstg.type_b.repository.UserRepository;
import com.fstg.type_b.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{
final UserRepository utilisateurRepository;
final UserPostConverter utilisateurPostConverter;
final UserGetDtoConverter utilisateurGetDtoConverter;

@Override
public User save(UserPostDto utilisateurPostDto) throws Exception{

    User  utilisateurById = utilisateurRepository.findById(utilisateurPostDto.getId()).orElse(null);

    Optional<User> utilisateurByEmail = utilisateurRepository.findByEmail(utilisateurPostDto.getEmail());

User utilisateurByTelephone = utilisateurRepository.findByTelephone(utilisateurPostDto.getTelephone());
if(utilisateurById != null || utilisateurByEmail != null || utilisateurByTelephone != null) throw new Exception("User already exists");
return utilisateurRepository.save(utilisateurPostConverter.convertToDM(utilisateurPostDto));  

}
@Override
public User update(UserPostDto userPostDto) throws Exception{
User utilisateurFromDB = utilisateurRepository.findById(userPostDto.getId()).orElse(null);
if(utilisateurFromDB == null) throw new Exception("User not found");
userPostDto.setId(utilisateurFromDB.getId());
return utilisateurRepository.save(utilisateurPostConverter.convertToDM(userPostDto));

}
@Override
public Long delete(Long id) throws Exception{
User utilisateurFromDB = utilisateurRepository.findById(id).orElse(null);

if(utilisateurFromDB == null ) throw new Exception("User not found");
utilisateurRepository.delete(utilisateurFromDB);
return id;
}

@Override
   public  List<UserGetDto> findAll(){
return utilisateurGetDtoConverter.convertToDTOs(utilisateurRepository.findAll());

}
}
