/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.payload.request.holder;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author USER
 */
@Getter
@Setter
public class DemandeHolder {
    //demande
private String intitule;
private Date dateDebut;
private Date dateFin;
private String status;
private String dateEnvoi;
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

//soutien sollicité
private String rubrique;
private String montant;
private BigDecimal nombre;
private String remarques;
private BigDecimal montantGlobal;

//Entité organisatrice
private String nom;
private String responsable;

//Etablissement
private String reference;
private String intituleEtablissement;

//info coordonnateur
private String nomCoordonnateur;
private String prenom;
private String grade;
private String email;
private String telephone;
private String fax;

//

}
