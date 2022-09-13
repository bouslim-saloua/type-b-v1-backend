/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Etablissement implements Serializable{
    @Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String reference;
private String intitule;

@OneToMany(mappedBy="etablissement", cascade = CascadeType.ALL)
@JsonManagedReference
private List<Laboratoire> laboratoires;

@OneToMany(mappedBy="etablissement", cascade = CascadeType.ALL)
@JsonManagedReference
private List<EntiteOrganisatrice> entiteOrganisatrices;
@OneToMany(mappedBy="etablissement", cascade = CascadeType.ALL)
@JsonManagedReference
private List<CommiteOrganisation> commiteOrganisations;

@OneToMany(mappedBy="etablissement", cascade = CascadeType.ALL)
@JsonManagedReference
private List<Chercheur> chercheurs;
}
