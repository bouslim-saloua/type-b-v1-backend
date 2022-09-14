/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.converter.impl;

import com.fstg.type_b.converter.AbstractConverter;
import com.fstg.type_b.dto.UserGetDto;
import com.fstg.type_b.model.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.stereotype.Component;

/**
 *
 * @author USER
 */
@Component
public class UserGetDtoConverter extends AbstractConverter<User, UserGetDto>{
    private final ModelMapper modelMapper;

public UserGetDtoConverter(ModelMapper modelMapper){
modelMapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
this.modelMapper = modelMapper;
}

@Override
public User convertToDM(UserGetDto utilisateurGetDto){
return modelMapper.map(utilisateurGetDto, User.class);
}

@Override
public UserGetDto convertToDTO(User utilisateur){
return modelMapper.map(utilisateur, UserGetDto.class);
}
}