/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
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
public class Coordonnateur implements Serializable{
    @Id
@GeneratedValue(strategy= GenerationType.AUTO)
private Long id;
private String nom;
private String prenom;
private String grade;
private String email;
private String telephone;
private String fax;

@JsonManagedReference
@OneToMany(mappedBy="coordonnateur", cascade=CascadeType.ALL)
private List<Demande> demandes;
}
