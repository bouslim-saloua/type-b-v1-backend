/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;



/**
 *
 * @author USER
 */
@Data
@Entity
public class Demandeur extends User{
    @OneToMany(mappedBy = "demandeur", cascade = CascadeType.ALL)
@JsonManagedReference
    private List<Demande> demandes;


public Demandeur(String nom, String prenom, String telephone, String email, String encode, String profession) {
       super(nom, prenom, telephone, email, encode, profession);
    }
public Demandeur(String email, String encode){
super(email, encode);
}

//default constructor
public Demandeur(){
}
}
