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
public class GestionFinanciere implements Serializable{
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String libelle;
private String information;
//reference vers l id_demande
 @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "demande_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
@JsonBackReference
private Demande demande;
}
