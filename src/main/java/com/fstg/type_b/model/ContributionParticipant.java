/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import lombok.Data;

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

@ManyToOne
private NatureContribution natureContribution;

@ManyToOne
private TypeContributeur type;
}
