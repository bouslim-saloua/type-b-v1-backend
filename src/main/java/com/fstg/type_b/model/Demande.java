/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

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
private Long nombreParticipant;
private String siteWebManifestation;

@OneToMany(mappedBy="demande")
private List<GestionFinanciere> gestionFinancieres;
@OneToMany(mappedBy="demande")
private List<
}
