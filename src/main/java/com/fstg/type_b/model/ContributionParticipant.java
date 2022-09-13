/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
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
public class ContributionParticipant implements Serializable{
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private BigDecimal montant;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "nature_contribution_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private NatureContribution natureContribution;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "type_contributeur_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private TypeContributeur typeContributeur;


@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "demande_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private Demande demande;
}
