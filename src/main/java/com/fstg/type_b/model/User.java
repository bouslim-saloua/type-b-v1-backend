/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fstg.type_b.model;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author USER
 */
@Data
@Entity
public class User  implements Serializable{
    @Id 
@GeneratedValue(strategy = GenerationType.AUTO)
private Long id;
private String nom;
private String prenom;
private String email;
private String password;
private String telephone;
private String profession;

}
