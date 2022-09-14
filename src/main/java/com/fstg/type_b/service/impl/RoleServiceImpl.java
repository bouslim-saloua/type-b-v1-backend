/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.service.impl;

import com.fstg.type_b.model.ERole;
import com.fstg.type_b.model.Role;
import com.fstg.type_b.repository.RoleRepository;
import com.fstg.type_b.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */
@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    final RoleRepository roleRepository;

@Override
public   Role findByName(ERole name){
return  roleRepository.findByName(name);
}
@Override
public Role save(Role role){
return roleRepository.save(role);
}

}