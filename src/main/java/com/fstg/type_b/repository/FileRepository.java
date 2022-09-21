/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.repository;

import com.fstg.type_b.model.File;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USER
 */
@Repository
public interface FileRepository extends JpaRepository<File, String>{
    @Query(value="SELECT * FROM File m WHERE m.demande_id = :demandeId ", nativeQuery = true)
public List<File> findAllFilesByDemande(@Param("demandeId") Long demandeId);

    public Object findById(Long demandeId);
}
