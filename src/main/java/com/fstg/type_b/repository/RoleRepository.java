/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.repository;

import com.fstg.type_b.model.ERole;
import com.fstg.type_b.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
