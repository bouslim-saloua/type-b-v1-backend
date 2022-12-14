/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author USER
 */

@Data
@Entity
public class CommiteOrganisation implements Serializable {
    @Id
@GeneratedValue(strategy= GenerationType.AUTO)
private Long id;
private String nom; 
private String prenom;
private String telephone;
private String email;
private String ville;
private String type;
private String pays;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "etablissement_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private Etablissement etablissement;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "demande_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private Demande demande;
}
