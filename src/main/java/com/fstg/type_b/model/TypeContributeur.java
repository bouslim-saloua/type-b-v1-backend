/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author USER
 */

@Data
@Entity
public class TypeContributeur implements Serializable {

    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String libelle;

@OneToMany
private List<ContributionParticipant> contributionsParticipants;
}
