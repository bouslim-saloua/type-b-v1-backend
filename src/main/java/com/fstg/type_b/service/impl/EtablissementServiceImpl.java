/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.service.impl;

import com.fstg.type_b.model.Etablissement;
import com.fstg.type_b.repository.EtablissementRepository;
import com.fstg.type_b.service.EtablissementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
@RequiredArgsConstructor
public class EtablissementServiceImpl implements EtablissementService{
    private final EtablissementRepository etablissementRepository;

@Override
public List<Etablissement> findAll(){
return etablissementRepository.findAll();
}

@Override
public int save(Etablissement etablissement){
Etablissement etablissementDb = etablissementRepository.findByReference(etablissement.getReference());
Etablissement etablissementByIntitule = etablissementRepository.findByIntitule(etablissement.getIntitule());
if(etablissementDb != null){
return -1;
}else if(etablissementByIntitule != null){
return -2;
}else{
etablissementRepository.save(etablissement);
return 1;
}
}

}
