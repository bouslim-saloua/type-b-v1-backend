/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.service;

import com.fstg.type_b.dto.UserGetDto;
import com.fstg.type_b.dto.UserPostDto;
import com.fstg.type_b.model.User;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */

public interface UserService {


User save(UserPostDto userPostDto) throws Exception;
User update(UserPostDto utilisateurPostDto) throws Exception;
//UtilisateurGetDto findByEmail(String email);
Long delete(Long id) throws Exception;

    List<UserGetDto> findAll();

}
