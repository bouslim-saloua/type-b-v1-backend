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
public class Chercheur implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;

private String nom;
private String prenom;
private String structure;
 @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "etablissement_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
@JsonBackReference
private Etablissement etablissement;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "laboratoir_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
@JsonBackReference
private Laboratoire laboratoire;
}
