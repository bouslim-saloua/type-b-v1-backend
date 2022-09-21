/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.controller;

import com.fstg.type_b.model.Etablissement;
import com.fstg.type_b.service.EtablissementService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */
@Api
@RequestMapping("/api/etablissement")
@RestController
@RequiredArgsConstructor
public class EtablissementController {
    private final EtablissementService etablissementService;

@PostMapping("/newEtablissement")
public ResponseEntity<?> save(@RequestBody Etablissement etablissement){
return ResponseEntity.ok(etablissementService.save(etablissement));
}

@GetMapping("/all/etablissement")
public ResponseEntity<?> findAll(){
return ResponseEntity.ok(etablissementService.findAll());
}
}
