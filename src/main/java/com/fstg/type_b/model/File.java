/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author USER
 */
@Data
@Entity
public class File implements Serializable{
    @Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name= "uuid", strategy="uuid2") 
private String id;
private String libelle;
private String nom; 
private String type;
@Lob
private byte[] data;

@ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "demande_id", nullable = true)
  @OnDelete(action = OnDeleteAction.CASCADE)  
@JsonBackReference
private Demande demande;

public File(String libelle, String nom, String type, byte[] data){
this.libelle   = libelle;
this.nom = nom;
this.type = type;
this.data = data;
}

//default constructor
public File(){
}


}
