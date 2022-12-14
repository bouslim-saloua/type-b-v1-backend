/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.repository;

import com.fstg.type_b.model.Demandeur;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface DemandeurRepository extends JpaRepository<Demandeur, Long> {
     Optional<Demandeur> findByEmail(String email);
Demandeur findByTelephone(String telephone);
Boolean existsByEmail(String email);
Boolean existsByTelephone(String telephone);
}
