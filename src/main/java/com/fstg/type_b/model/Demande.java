/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
public class Demande implements Serializable {
    @Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long id;
private String intitule;
@Temporal(TemporalType.DATE)
 @JsonFormat(pattern="yyyy-MM-dd")
private Date dateDebut;
@Temporal(TemporalType.DATE)
 @JsonFormat(pattern="yyyy-MM-dd")
private Date dateFin;
private String status;

//dateCreation
@Temporal(TemporalType.DATE)
 @JsonFormat(pattern="yyyy-MM-dd")
private Date dateEnvoi;
private String remarque;
private String lieu;
private Long nombreParticipantPrevus;
private String siteWebManifestation;
private String type;
private String partenaires;
private int nombreEtudiantLocaux;
private int nombreEtudiantNonLocaux;
private int nombreEnseignantLocaux;
private int nombreEnseignantNonLocaux;
private String agenceOrganisatrice;

@OneToMany(mappedBy="demande")
@JsonIgnore
private List<GestionFinanciere> gestionFinancieres;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "coordonnateur_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private Coordonnateur coordonnateur;

@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "demande")
@JsonManagedReference
private SoutienSollicite soutienSollicite;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "entite_organisatrice_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private EntiteOrganisatrice entiteOrganisatrice;

@OneToMany(mappedBy="demande", cascade = CascadeType.ALL)
@JsonManagedReference
private List<Contributeur> contributeurs;

@OneToMany(mappedBy="demande", cascade = CascadeType.ALL)
@JsonManagedReference
private List<ContributionParticipant> contributionParticipants;

@OneToMany(mappedBy="demande", cascade = CascadeType.ALL)
@JsonManagedReference
private List<CommiteOrganisation> commiteOrganisations;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private Demandeur demandeur;
//les partenaires

@OneToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "soutien_accorde_id", nullable = true)
@JsonManagedReference
private SoutienAccorde soutienAccorde;

}
