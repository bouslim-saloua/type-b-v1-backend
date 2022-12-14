/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.repository;

import com.fstg.type_b.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
     Optional<User> findByEmail(String email);
User findByTelephone(String telephone);
Optional<User> findById(Long id);
Boolean existsByEmail(String email);
Boolean existsByTelephone(String telephone);
}
