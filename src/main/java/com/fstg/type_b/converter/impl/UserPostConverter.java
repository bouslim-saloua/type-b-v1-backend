/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.converter.impl;

import com.fstg.type_b.converter.AbstractConverter;
import com.fstg.type_b.dto.UserPostDto;
import com.fstg.type_b.model.User;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;


/**
 *
 * @author USER
 */

@Component
public class UserPostConverter extends AbstractConverter<User, UserPostDto>{
    private final ModelMapper modelMapper;

public UserPostConverter(ModelMapper modelMapper){
        modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
this.modelMapper = modelMapper;
}

//From dto to model
@Override
public User convertToDM(UserPostDto utilisateurPostDto){
return modelMapper.map(utilisateurPostDto, User.class);
}

//From model to dto
@Override
public UserPostDto convertToDTO(User utilisateur){
return modelMapper.map(utilisateur, UserPostDto.class);
}

}

