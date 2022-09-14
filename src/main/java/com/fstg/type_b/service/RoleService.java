/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.service;

import com.fstg.type_b.model.ERole;
import com.fstg.type_b.model.Role;

/**
 *
 * @author USER
 */
public interface RoleService {
     //Optional<Role> findByName(ERole name);
Role findByName(ERole name);
Role save(Role role);

}