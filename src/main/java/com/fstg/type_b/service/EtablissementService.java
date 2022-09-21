/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fstg.type_b.service;

import com.fstg.type_b.model.Etablissement;
import java.util.List;

/**
 *
 * @author USER
 */


public interface EtablissementService {
int save(Etablissement etablissement);
    List<Etablissement> findAll();
}
